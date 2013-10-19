package common.kodehawa.reeszrbteam.ce.util;

import java.util.Scanner;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BlockFilter {

	public static String idToBlockName(final int id){
		 for (final Block e : Block.blocksList) {
			   if (e == null) {
			    continue;
			   }

			   if (e.blockID == id) {
			    return e.getLocalizedName();
			   }
		 }
		 
		 return "";
	}
	
	public static int blockNametoID(String name){
		for (final Block e : Block.blocksList) {
			   if (e == null) {
			    continue;
			   }
			   
			   String s = e.getLocalizedName().replaceAll(" ", "").toLowerCase();
			   if(name.equalsIgnoreCase(s)){
				   return e.blockID;
			   }
		 }
		 
		 return 90000;
	}
}
