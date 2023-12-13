package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.StringUtil;
import com.replaymod.lib.org.mortbay.util.TypeUtil;
import java.security.MessageDigest;

public abstract class Credential {
   public abstract boolean check(Object var1);

   public static Credential getCredential(String credential) {
      if (credential.startsWith("CRYPT:")) {
         return new Credential.Crypt(credential);
      } else {
         return (Credential)(credential.startsWith("MD5:") ? new Credential.MD5(credential) : new Password(credential));
      }
   }

   public static class MD5 extends Credential {
      public static final String __TYPE = "MD5:";
      public static final Object __md5Lock = new Object();
      private static MessageDigest __md;
      private byte[] _digest;

      MD5(String digest) {
         digest = digest.startsWith("MD5:") ? digest.substring("MD5:".length()) : digest;
         this._digest = TypeUtil.parseBytes(digest, 16);
      }

      public byte[] getDigest() {
         return this._digest;
      }

      public boolean check(Object credentials) {
         try {
            byte[] digest = null;
            if (!(credentials instanceof Password) && !(credentials instanceof String)) {
               if (credentials instanceof Credential.MD5) {
                  Credential.MD5 md5 = (Credential.MD5)credentials;
                  if (this._digest.length != md5._digest.length) {
                     return false;
                  } else {
                     for(int i = 0; i < this._digest.length; ++i) {
                        if (this._digest[i] != md5._digest[i]) {
                           return false;
                        }
                     }

                     return true;
                  }
               } else if (credentials instanceof Credential) {
                  return ((Credential)credentials).check(this);
               } else {
                  Log.warn("Can't check " + credentials.getClass() + " against MD5");
                  return false;
               }
            } else {
               byte[] digest;
               synchronized(__md5Lock) {
                  if (__md == null) {
                     __md = MessageDigest.getInstance("MD5");
                  }

                  __md.reset();
                  __md.update(credentials.toString().getBytes(StringUtil.__ISO_8859_1));
                  digest = __md.digest();
               }

               if (digest != null && digest.length == this._digest.length) {
                  for(int i = 0; i < digest.length; ++i) {
                     if (digest[i] != this._digest[i]) {
                        return false;
                     }
                  }

                  return true;
               } else {
                  return false;
               }
            }
         } catch (Exception var6) {
            Log.warn((Throwable)var6);
            return false;
         }
      }

      public static String digest(String password) {
         try {
            byte[] digest;
            synchronized(__md5Lock) {
               if (__md == null) {
                  try {
                     __md = MessageDigest.getInstance("MD5");
                  } catch (Exception var5) {
                     Log.warn((Throwable)var5);
                     return null;
                  }
               }

               __md.reset();
               __md.update(password.getBytes(StringUtil.__ISO_8859_1));
               digest = __md.digest();
            }

            return "MD5:" + TypeUtil.toString(digest, 16);
         } catch (Exception var7) {
            Log.warn((Throwable)var7);
            return null;
         }
      }
   }

   public static class Crypt extends Credential {
      public static final String __TYPE = "CRYPT:";
      private String _cooked;

      Crypt(String cooked) {
         this._cooked = cooked.startsWith("CRYPT:") ? cooked.substring("CRYPT:".length()) : cooked;
      }

      public boolean check(Object credentials) {
         if (!(credentials instanceof String) && !(credentials instanceof Password)) {
            Log.warn("Can't check " + credentials.getClass() + " against CRYPT");
         }

         String passwd = credentials.toString();
         return this._cooked.equals(UnixCrypt.crypt(passwd, this._cooked));
      }

      public static String crypt(String user, String pw) {
         return "CRYPT:" + UnixCrypt.crypt(pw, user);
      }
   }
}
