package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class PageInfo extends GenericJson {
   @Key
   private Integer resultsPerPage;
   @Key
   private Integer totalResults;

   public Integer getResultsPerPage() {
      return this.resultsPerPage;
   }

   public PageInfo setResultsPerPage(Integer var1) {
      this.resultsPerPage = var1;
      return this;
   }

   public Integer getTotalResults() {
      return this.totalResults;
   }

   public PageInfo setTotalResults(Integer var1) {
      this.totalResults = var1;
      return this;
   }

   public PageInfo set(String var1, Object var2) {
      return (PageInfo)super.set(var1, var2);
   }

   public PageInfo clone() {
      return (PageInfo)super.clone();
   }
}
