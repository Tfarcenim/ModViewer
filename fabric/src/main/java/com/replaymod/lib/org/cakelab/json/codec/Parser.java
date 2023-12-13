package com.replaymod.lib.org.cakelab.json.codec;

import com.replaymod.lib.org.cakelab.json.JSONArray;
import com.replaymod.lib.org.cakelab.json.JSONException;
import com.replaymod.lib.org.cakelab.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Parser {
   Scanner scanner;
   private boolean ignoreNull;

   public Parser(String jsonString, boolean ignoreNull) throws IOException {
      this.ignoreNull = ignoreNull;
      this.scanner = new Scanner(jsonString);
   }

   public Parser(String jsonString) throws IOException {
      this(jsonString, false);
   }

   public Parser(InputStream in, Charset charset, boolean ignoreNull) throws IOException {
      this.ignoreNull = ignoreNull;
      this.scanner = new Scanner(in, charset);
   }

   public Parser(InputStream in, boolean ignoreNull) throws IOException {
      this(in, Charset.defaultCharset(), ignoreNull);
   }

   public Parser(InputStream in, Charset charset) throws IOException {
      this(in, charset, false);
   }

   public Parser(InputStream in) throws IOException {
      this(in, Charset.defaultCharset(), false);
   }

   public JSONObject parse() throws IOException, JSONException {
      return this.parseObject();
   }

   private JSONObject parseObject() throws IOException, JSONException {
      JSONObject o = new JSONObject();
      this.scanCharToken(123);
      this.parseNVSequence(o, 125);
      this.scanCharToken(125);
      return o;
   }

   private void parseNVSequence(JSONObject o, int endToken) throws IOException, JSONException {
      char lookahead = this.scanner.getLookahead();
      if (lookahead != endToken) {
         while(true) {
            this.parseNameValuePair(o);
            lookahead = this.scanner.getLookahead();
            if (lookahead == endToken) {
               return;
            }

            this.scanCharToken(44);
         }
      }
   }

   private void parseValueSequence(JSONArray o, int endToken) throws IOException, JSONException {
      char lookahead = this.scanner.getLookahead();
      if (lookahead != endToken) {
         while(true) {
            Object value = this.parseValue();
            if (!this.ignoreNull || value != null) {
               o.add(value);
            }

            lookahead = this.scanner.getLookahead();
            if (lookahead == endToken) {
               return;
            }

            this.scanCharToken(44);
         }
      }
   }

   private void parseNameValuePair(JSONObject parent) throws IOException, JSONException {
      if (this.scanner.nextName() != 2048) {
         this.error("expected a name");
      }

      String name = this.scanner.getName();
      this.scanCharToken(58);
      Object value = this.parseValue();
      if (!this.ignoreNull || value != null) {
         parent.put(name, value);
      }
   }

   private Object parseValue() throws IOException, JSONException {
      Object value = null;
      char lookahead = this.scanner.getLookahead();
      switch(lookahead) {
      case '[':
         value = this.parseArray();
         break;
      case '{':
         value = this.parseObject();
         break;
      default:
         int type = this.scanner.nextValue();
         if (type == Integer.MAX_VALUE) {
            this.error("expected a value");
         }

         value = this.scanner.getValue();
      }

      return value;
   }

   private JSONArray parseArray() throws IOException, JSONException {
      JSONArray a = new JSONArray();
      this.scanCharToken(91);
      if (this.scanner.getLookahead() != ']') {
         this.parseValueSequence(a, 93);
      }

      this.scanCharToken(93);
      return a;
   }

   private void scanCharToken(int tokenCharacter) throws IOException, JSONException {
      if (this.scanner.next() != (char)tokenCharacter) {
         this.error("expected token '" + (char)tokenCharacter + "'");
      }

   }

   private void error(String string) throws JSONException {
      throw new JSONException(":" + this.scanner.getLine() + ":" + this.scanner.getColumn() + ": " + string);
   }
}
