package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.jetty.HttpConnection;
import com.replaymod.lib.org.mortbay.jetty.handler.ContextHandler;
import com.replaymod.lib.org.mortbay.jetty.handler.ErrorHandler;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.TypeUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorPageErrorHandler extends ErrorHandler {
   protected ServletContext _servletContext;
   protected Map _errorPages;
   protected List _errorPageList;

   public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException {
      String method = request.getMethod();
      if (!method.equals("GET") && !method.equals("POST") && !method.equals("HEAD")) {
         HttpConnection.getCurrentConnection().getRequest().setHandled(true);
      } else {
         if (this._errorPages != null) {
            String error_page = null;
            Class exClass = (Class)request.getAttribute("javax.servlet.error.exception_type");
            if (ServletException.class.equals(exClass)) {
               error_page = (String)this._errorPages.get(exClass.getName());
               if (error_page == null) {
                  Throwable th;
                  for(th = (Throwable)request.getAttribute("javax.servlet.error.exception"); th instanceof ServletException; th = ((ServletException)th).getRootCause()) {
                  }

                  if (th != null) {
                     exClass = th.getClass();
                  }
               }
            }

            while(error_page == null && exClass != null) {
               error_page = (String)this._errorPages.get(exClass.getName());
               exClass = exClass.getSuperclass();
            }

            if (error_page == null) {
               Integer code = (Integer)request.getAttribute("javax.servlet.error.status_code");
               if (code != null) {
                  error_page = (String)this._errorPages.get(TypeUtil.toString(code));
                  if (error_page == null && this._errorPageList != null) {
                     for(int i = 0; i < this._errorPageList.size(); ++i) {
                        ErrorPageErrorHandler.ErrorCodeRange errCode = (ErrorPageErrorHandler.ErrorCodeRange)this._errorPageList.get(i);
                        if (errCode.isInRange(code)) {
                           error_page = errCode.getUri();
                           break;
                        }
                     }
                  }
               }
            }

            if (error_page != null) {
               String old_error_page = (String)request.getAttribute("com.replaymod.lib.org.mortbay.jetty.error_page");
               if (old_error_page == null || !old_error_page.equals(error_page)) {
                  request.setAttribute("com.replaymod.lib.org.mortbay.jetty.error_page", error_page);
                  Dispatcher dispatcher = (Dispatcher)this._servletContext.getRequestDispatcher(error_page);

                  try {
                     if (dispatcher != null) {
                        dispatcher.error(request, response);
                        return;
                     }

                     Log.warn("No error page " + error_page);
                  } catch (ServletException var11) {
                     Log.warn("EXCEPTION ", (Throwable)var11);
                     return;
                  }
               }
            }
         }

         super.handle(target, request, response, dispatch);
      }
   }

   public Map getErrorPages() {
      return this._errorPages;
   }

   public void setErrorPages(Map errorPages) {
      this._errorPages = errorPages;
   }

   public void addErrorPage(Class exception, String uri) {
      if (this._errorPages == null) {
         this._errorPages = new HashMap();
      }

      this._errorPages.put(exception.getName(), uri);
   }

   public void addErrorPage(int code, String uri) {
      if (this._errorPages == null) {
         this._errorPages = new HashMap();
      }

      this._errorPages.put(TypeUtil.toString(code), uri);
   }

   public void addErrorPage(int from, int to, String uri) {
      if (this._errorPageList == null) {
         this._errorPageList = new ArrayList();
      }

      this._errorPageList.add(new ErrorPageErrorHandler.ErrorCodeRange(from, to, uri));
   }

   protected void doStart() throws Exception {
      super.doStart();
      this._servletContext = ContextHandler.getCurrentContext();
   }

   protected void doStop() throws Exception {
      super.doStop();
   }

   private class ErrorCodeRange {
      private int _from;
      private int _to;
      private String _uri;

      ErrorCodeRange(int from, int to, String uri) throws IllegalArgumentException {
         if (from > to) {
            throw new IllegalArgumentException("from>to");
         } else {
            this._from = from;
            this._to = to;
            this._uri = uri;
         }
      }

      boolean isInRange(int value) {
         return value >= this._from && value <= this._to;
      }

      String getUri() {
         return this._uri;
      }

      public String toString() {
         return "from: " + this._from + ",to: " + this._to + ",uri: " + this._uri;
      }
   }
}
