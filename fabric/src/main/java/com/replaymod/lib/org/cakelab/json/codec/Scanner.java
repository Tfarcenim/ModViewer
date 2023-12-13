package com.replaymod.lib.org.cakelab.json.codec;

import com.replaymod.lib.org.cakelab.json.JSONException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;

public class Scanner {
   private Reader reader;
   private int lookahead;
   private int line;
   private int column;
   private double double_value;
   private String string_value;
   private boolean boolean_value;
   private String name;
   private Object value;
   private long int_value;

   public Scanner(Reader reader) throws IOException {
      this.reader = reader;
      this.line = 1;
      this.column = 1;
      this.readCharacter();
   }

   public Scanner(InputStream in, Charset charset) throws IOException {
      this((Reader)(new InputStreamReader(in, charset)));
   }

   public Scanner(InputStream in) throws IOException {
      this(in, Charset.defaultCharset());
   }

   public Scanner(String jsonString) throws IOException {
      this((Reader)(new StringReader(jsonString)));
   }

   public int next() throws IOException {
      char c = this.readCharacterSkipWhitespace();
      return c;
   }

   public int nextName() throws IOException, JSONException {
      this.getLookahead();
      this.name = this.readString();
      return 2048;
   }

   public String getName() {
      return this.name;
   }

   public int nextValue() throws IOException, JSONException {
      char c = this.getLookahead();
      if (c == '"') {
         return this.nextStringValue();
      } else if (!Token.isDigit(c) && c != '+' && c != '-') {
         if (Character.toLowerCase(c) != 't' && Character.toLowerCase(c) != 'f') {
            return Character.toLowerCase(c) == 'n' ? this.nextNullValue() : Integer.MAX_VALUE;
         } else {
            return this.nextBooleanValue();
         }
      } else {
         return this.nextNumberValue();
      }
   }

   public boolean getBooleanValue() {
      return this.boolean_value;
   }

   public double getNumberValue() {
      return this.double_value;
   }

   public String getStringValue() {
      return this.string_value;
   }

   private int nextNullValue() throws IOException {
      char c = Character.toLowerCase(this.readCharacter());
      if (c == 'n') {
         c = Character.toLowerCase(this.readCharacter());
         if (c == 'u') {
            c = Character.toLowerCase(this.readCharacter());
            if (c == 'l') {
               c = Character.toLowerCase(this.readCharacter());
               if (c == 'l') {
                  this.value = null;
                  return 1027;
               }
            }
         }
      }

      return 0;
   }

   private int nextBooleanValue() throws IOException, JSONException {
      char c = Character.toLowerCase(this.readCharacter());
      if (c == 't') {
         c = Character.toLowerCase(this.readCharacter());
         if (c == 'r') {
            c = Character.toLowerCase(this.readCharacter());
            if (c == 'u') {
               c = Character.toLowerCase(this.readCharacter());
               if (c == 'e') {
                  this.boolean_value = true;
                  this.value = this.boolean_value;
                  return 1026;
               }
            }
         }
      } else if (c == 'f') {
         c = Character.toLowerCase(this.readCharacter());
         if (c == 'a') {
            c = Character.toLowerCase(this.readCharacter());
            if (c == 'l') {
               c = Character.toLowerCase(this.readCharacter());
               if (c == 's') {
                  c = Character.toLowerCase(this.readCharacter());
                  if (c == 'e') {
                     this.boolean_value = false;
                     this.value = this.boolean_value;
                     return 1026;
                  }
               }
            }
         }
      }

      this.error("Unknown character in boolean value: \\" + c);
      return 0;
   }

   private int nextNumberValue() throws IOException, JSONException {
      StringBuffer s = new StringBuffer();
      char c = this.readCharacter();
      s.append(c);

      while("0123456789.+-eE".indexOf(this.lookahead) >= 0) {
         c = this.readCharacter();
         s.append(c);
      }

      try {
         try {
            this.int_value = Long.parseLong(s.toString());
            this.value = this.int_value;
         } catch (NumberFormatException var4) {
            this.double_value = Double.parseDouble(s.toString());
            this.value = this.double_value;
         }
      } catch (NumberFormatException var5) {
         this.error(s.toString() + " does not comply to json number format");
      }

      return 1025;
   }

   public char getLookahead() throws IOException {
      while(Token.isWhitespace((char)this.lookahead)) {
         this.readCharacter();
      }

      if (this.lookahead < 0) {
         throw new IOException("EOF (missing brackets?)");
      } else {
         return (char)this.lookahead;
      }
   }

   private char readCharacterSkipWhitespace() throws IOException {
      char c;
      for(c = this.readCharacter(); Token.isWhitespace(c); c = this.readCharacter()) {
      }

      return c;
   }

   private char readCharacter() throws IOException {
      if (this.lookahead < 0) {
         throw new IOException("EOF");
      } else {
         int c = this.reader.read();
         char result = (char)this.lookahead;
         this.lookahead = c;
         ++this.column;
         if (result == '\n') {
            this.newline();
         }

         return result;
      }
   }

   private int nextStringValue() throws IOException, JSONException {
      this.string_value = this.readString();
      this.value = this.string_value;
      return 1024;
   }

   private String readString() throws IOException, JSONException {
      StringBuffer s = new StringBuffer();
      if ('"' != this.readCharacter()) {
         this.error("expected '\"'");
      }

      char c;
      for(; '"' != (c = this.readCharacter()); s.append(c)) {
         if (c == '\\') {
            c = this.readControlCharacter();
         }
      }

      return s.toString();
   }

   private char readControlCharacter() throws IOException, JSONException {
      char c = this.readCharacter();
      switch(c) {
      case '"':
         return '"';
      case '/':
         return '/';
      case '\\':
         return '\\';
      case 'b':
         return '\b';
      case 'f':
         return '\f';
      case 'n':
         return '\n';
      case 'r':
         return '\r';
      case 't':
         return '\t';
      case 'u':
         return this.readUnicodeControlSequence();
      default:
         this.error("Unknown control sequence: \\" + c);
         return '\u0000';
      }
   }

   private void error(String msg) throws JSONException {
      throw new JSONException(": " + this.line + ':' + this.column + ": error:" + msg);
   }

   private char readUnicodeControlSequence() throws IOException, JSONException {
      int hex = this.readHexDigits(4);
      return (char)hex;
   }

   private int readHexDigits(int amount) throws IOException, JSONException {
      int radix = 16;
      int hex = 0;

      for(int i = 0; i < amount; ++i) {
         if (!Token.isHexDigit((char)this.lookahead)) {
            this.error("Unexpected character in unicode control sequence");
         }

         char c = this.readCharacter();
         hex *= radix;
         hex += Character.digit(c, radix);
      }

      return hex;
   }

   private void newline() {
      ++this.line;
      this.column = 1;
   }

   public int getLine() {
      return this.line;
   }

   public int getColumn() {
      return this.column;
   }

   public Object getValue() {
      return this.value;
   }
}
