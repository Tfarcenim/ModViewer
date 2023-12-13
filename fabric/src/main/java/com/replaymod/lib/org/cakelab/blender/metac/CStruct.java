package com.replaymod.lib.org.cakelab.blender.metac;

import com.replaymod.lib.org.cakelab.blender.io.dna.DNAStruct;
import java.util.ArrayList;

public class CStruct extends CType {
   int sdnaIndex;
   private ArrayList<CField> fields = new ArrayList();

   public CStruct(DNAStruct bstruct) {
      super(bstruct.getType().getName(), CType.CKind.TYPE_STRUCT);
      this.sdnaIndex = bstruct.getIndex();
   }

   public void addField(CField cfield) {
      this.fields.add(cfield);
   }

   public ArrayList<CField> getFields() {
      return this.fields;
   }

   public int getSdnaIndex() {
      return this.sdnaIndex;
   }
}
