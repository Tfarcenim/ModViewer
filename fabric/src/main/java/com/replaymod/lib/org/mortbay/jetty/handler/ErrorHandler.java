package com.replaymod.lib.org.mortbay.jetty.handler;

import com.replaymod.lib.org.mortbay.jetty.HttpConnection;
import com.replaymod.lib.org.mortbay.jetty.HttpGenerator;
import com.replaymod.lib.org.mortbay.util.ByteArrayISO8859Writer;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandler extends AbstractHandler {
   boolean _showStacks = true;
   String _cacheControl = "must-revalidate,no-cache,no-store";

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException {
      HttpConnection connection = HttpConnection.getCurrentConnection();
      connection.getRequest().setHandled(true);
      String method = request.getMethod();
      if (method.equals("GET") || method.equals("POST") || method.equals("HEAD")) {
         response.setContentType("text/html; charset=iso-8859-1");
         if (this._cacheControl != null) {
            response.setHeader("Cache-Control", this._cacheControl);
         }

         ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer(4096);
         this.handleErrorPage(request, writer, connection.getResponse().getStatus(), connection.getResponse().getReason());
         writer.flush();
         response.setContentLength(writer.size());
         writer.writeTo(response.getOutputStream());
         writer.destroy();
      }
   }

   protected void handleErrorPage(HttpServletRequest request, Writer writer, int code, String message) throws IOException {
      this.writeErrorPage(request, writer, code, message, this._showStacks);
   }

   protected void writeErrorPage(HttpServletRequest request, Writer writer, int code, String message, boolean showStacks) throws IOException {
      if (message == null) {
         message = HttpGenerator.getReason(code);
      }

      writer.write("<html>\n<head>\n");
      this.writeErrorPageHead(request, writer, code, message);
      writer.write("</head>\n<body>");
      this.writeErrorPageBody(request, writer, code, message, showStacks);
      writer.write("\n</body>\n</html>\n");
   }

   protected void writeErrorPageHead(HttpServletRequest request, Writer writer, int code, String message) throws IOException {
      writer.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/>\n");
      writer.write("<title>Error ");
      writer.write(Integer.toString(code));
      writer.write(32);
      this.write(writer, message);
      writer.write("</title>\n");
   }

   protected void writeErrorPageBody(HttpServletRequest request, Writer writer, int code, String message, boolean showStacks) throws IOException {
      String uri = request.getRequestURI();
      this.writeErrorPageMessage(request, writer, code, message, uri);
      if (showStacks) {
         this.writeErrorPageStacks(request, writer);
      }

      writer.write("<hr /><i><small>Powered by Jetty://</small></i>");

      for(int i = 0; i < 20; ++i) {
         writer.write("<br/>                                                \n");
      }

   }

   protected void writeErrorPageMessage(HttpServletRequest request, Writer writer, int code, String message, String uri) throws IOException {
      writer.write("<h2>HTTP ERROR ");
      writer.write(Integer.toString(code));
      writer.write("</h2>\n<p>Problem accessing ");
      this.write(writer, uri);
      writer.write(". Reason:\n<pre>    ");
      this.write(writer, message);
      writer.write("</pre></p>");
   }

   protected void writeErrorPageStacks(HttpServletRequest request, Writer writer) throws IOException {
      for(Throwable th = (Throwable)request.getAttribute("javax.servlet.error.exception"); th != null; th = th.getCause()) {
         writer.write("<h3>Caused by:</h3><pre>");
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         th.printStackTrace(pw);
         pw.flush();
         this.write(writer, sw.getBuffer().toString());
         writer.write("</pre>\n");
      }

   }

   public String getCacheControl() {
      return this._cacheControl;
   }

   public void setCacheControl(String cacheControl) {
      this._cacheControl = cacheControl;
   }

   public boolean isShowStacks() {
      return this._showStacks;
   }

   public void setShowStacks(boolean showStacks) {
      this._showStacks = showStacks;
   }

   protected void write(Writer writer, String string) throws IOException {
      if (string != null) {
         for(int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            switch(c) {
            case '&':
               writer.write("&amp;");
               break;
            case '<':
               writer.write("&lt;");
               break;
            case '>':
               writer.write("&gt;");
               break;
            default:
               if (Character.isISOControl(c) && !Character.isWhitespace(c)) {
                  writer.write(63);
               } else {
                  writer.write(c);
               }
            }
         }

      }
   }
}
