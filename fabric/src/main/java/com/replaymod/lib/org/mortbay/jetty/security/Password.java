package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.log.Log;
import java.io.IOException;

public class Password extends Credential {
   public static final String __OBFUSCATE = "OBF:";
   private String _pw;

   public Password(String password) {
      for(this._pw = password; this._pw != null && this._pw.startsWith("OBF:"); this._pw = deobfuscate(this._pw)) {
      }

   }

   public String toString() {
      return this._pw;
   }

   public String toStarString() {
      return "*****************************************************".substring(0, this._pw.length());
   }

   public boolean check(Object credentials) {
      if (this == credentials) {
         return true;
      } else if (credentials instanceof Password) {
         return credentials.equals(this._pw);
      } else if (credentials instanceof String) {
         return credentials.equals(this._pw);
      } else {
         return credentials instanceof Credential ? ((Credential)credentials).check(this._pw) : false;
      }
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (null == o) {
         return false;
      } else if (!(o instanceof Password)) {
         return o instanceof String ? o.equals(this._pw) : false;
      } else {
         Password p = (Password)o;
         return p._pw == this._pw || null != this._pw && this._pw.equals(p._pw);
      }
   }

   public int hashCode() {
      return null == this._pw ? super.hashCode() : this._pw.hashCode();
   }

   public static String obfuscate(String s) {
      StringBuffer buf = new StringBuffer();
      byte[] b = s.getBytes();
      synchronized(buf) {
         buf.append("OBF:");
         int i = 0;

         while(i < b.length) {
            byte b1 = b[i];
            byte b2 = b[s.length() - (i + 1)];
            int i1 = 127 + b1 + b2;
            int i2 = 127 + b1 - b2;
            int i0 = i1 * 256 + i2;
            String x = Integer.toString(i0, 36);
            switch(x.length()) {
            case 1:
               buf.append('0');
            case 2:
               buf.append('0');
            case 3:
               buf.append('0');
            default:
               buf.append(x);
               ++i;
            }
         }

         return buf.toString();
      }
   }

   public static String deobfuscate(String s) {
      if (s.startsWith("OBF:")) {
         s = s.substring(4);
      }

      byte[] b = new byte[s.length() / 2];
      int l = 0;

      for(int i = 0; i < s.length(); i += 4) {
         String x = s.substring(i, i + 4);
         int i0 = Integer.parseInt(x, 36);
         int i1 = i0 / 256;
         int i2 = i0 % 256;
         b[l++] = (byte)((i1 + i2 - 254) / 2);
      }

      return new String(b, 0, l);
   }

   public static Password getPassword(String realm, String dft, String promptDft) {
      String passwd = System.getProperty(realm, dft);
      if (passwd == null || passwd.length() == 0) {
         try {
            System.out.print(realm + (promptDft != null && promptDft.length() > 0 ? " [dft]" : "") + " : ");
            System.out.flush();
            byte[] buf = new byte[512];
            int len = System.in.read(buf);
            if (len > 0) {
               passwd = (new String(buf, 0, len)).trim();
            }
         } catch (IOException var6) {
            Log.warn("EXCEPTION ", (Throwable)var6);
         }

         if (passwd == null || passwd.length() == 0) {
            passwd = promptDft;
         }
      }

      return new Password(passwd);
   }

   public static void main(String[] arg) {
      if (arg.length != 1 && arg.length != 2) {
         System.err.println("Usage - java org.mortbay.jetty.security.Password [<user>] <password>");
         System.err.println("If the password is ?, the user will be prompted for the password");
         System.exit(1);
      }

      String p = arg[arg.length == 1 ? 0 : 1];
      Password pw = "?".equals(p) ? new Password(p) : new Password(p);
      System.err.println(pw.toString());
      System.err.println(obfuscate(pw.toString()));
      System.err.println(Credential.MD5.digest(p));
      if (arg.length == 2) {
         System.err.println(Credential.Crypt.crypt(arg[0], pw.toString()));
      }

   }
}
