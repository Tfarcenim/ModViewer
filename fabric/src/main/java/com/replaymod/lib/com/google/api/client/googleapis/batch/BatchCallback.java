package com.replaymod.lib.com.google.api.client.googleapis.batch;

import com.replaymod.lib.com.google.api.client.http.HttpHeaders;
import java.io.IOException;

public interface BatchCallback<T, E> {
   void onSuccess(T var1, HttpHeaders var2) throws IOException;

   void onFailure(E var1, HttpHeaders var2) throws IOException;
}
