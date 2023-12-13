package com.replaymod.lib.com.google.api.client.googleapis.batch.json;

import com.replaymod.lib.com.google.api.client.googleapis.batch.BatchCallback;
import com.replaymod.lib.com.google.api.client.googleapis.json.GoogleJsonError;
import com.replaymod.lib.com.google.api.client.googleapis.json.GoogleJsonErrorContainer;
import com.replaymod.lib.com.google.api.client.http.HttpHeaders;
import java.io.IOException;

public abstract class JsonBatchCallback<T> implements BatchCallback<T, GoogleJsonErrorContainer> {
   public final void onFailure(GoogleJsonErrorContainer e, HttpHeaders responseHeaders) throws IOException {
      this.onFailure(e.getError(), responseHeaders);
   }

   public abstract void onFailure(GoogleJsonError var1, HttpHeaders var2) throws IOException;
}
