package common.kodehawa.ce.module.classes;

import java.util.List;

import com.google.common.collect.Lists;

import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventRender;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.CEBlockCoord;
import common.kodehawa.ce.util.GLHelper;

public class BlockFinder extends ModuleAbstract {

	/* This is just the old version. */
	public BlockFinder() {
		super(Category.RENDER);
	}
	
	private int size = 0, timer = 0;

	public static List<Integer> espList = Lists.newArrayList();
	public static CEBlockCoord[] espBlocks = new CEBlockCoord[10000000];
	 
	@Override
	public String getModuleName(){
		return "Block Finder";
	}
	
	@Override
	public void doRender(){
		timer++;
		if(timer >= 35){
			refresh();
			timer = 0;
		}
		
		for(int cur = 0; cur < size; cur++) {
			CEBlockCoord curBlock = espBlocks[cur];
			GLHelper.startDrawingESPs(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 0.0F, 0.0F, 1.0F);
		}
	}
	
	public void refresh(){
		size = 0;
		int radius = 65;
		for(int y = 0; y < 128; y++) {
			for(int x = 0; x < radius; x++) {
			for(int z = 0; z < radius; z++) {
				
				int cX = (int)getMinecraft().thePlayer.posX - (int)radius/2+x;
				int cY = y;
				int cZ = (int)getMinecraft().thePlayer.posZ - (int)radius/2+z;
				int ids = getWorld().getBlockId(cX, cY, cZ);

				if (espList.contains(ids)) {
				espBlocks[size++] = new CEBlockCoord(cX, cY, cZ);
			}
			}
			}
		}
	}
}