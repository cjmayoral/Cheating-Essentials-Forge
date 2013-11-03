package common.kodehawa.ce.module.classes;

import java.lang.reflect.Field;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class XRay extends AbstractModule
{
	
	public XRay() 
	{
		super(Category.RENDER);
		this.setKeybinding(Keyboard.KEY_X);
	}

	@Override
	public String getModuleName()
	{
		return "X-Ray";
	}
	
	@Override
	public void enable()
	{
		float[] bright = world().provider.lightBrightnessTable;
		for(int i = 0; i < bright.length; i++){
			bright[i] = 1.0F;
		}
		rerender();
		Object obj = Block.blocksList;
		try
		{
			Field field = Block.class.getDeclaredField("enabled");
			if(field != null){
				field.setAccessible(true);
				field.setBoolean(null, true);
			}
		}
		catch(Exception e){}
		
		this.addDefaultList();
	}
	
	@Override
	public void disable()
	{
		world().provider.registerWorld(world());
		rerender();
		Object obj = Block.blocksList;
		try
		{
			Field field = Block.class.getDeclaredField("enabled");
			if(field != null){
				field.setAccessible(true);
				field.setBoolean(null, false);
			}
		}
		catch(Exception e){}
		
		this.removeDefaultList();
	}
	
	private void addDefaultList()
	{
		try
		{
			Field field = Block.class.getDeclaredField("xrayList");
			field.setAccessible(true);
			ArrayList<Integer> xray = (ArrayList<Integer>) field.get(null);
			xray.add(Block.oreCoal.blockID);
			xray.add(Block.oreIron.blockID);
			xray.add(Block.oreGold.blockID);
			xray.add(Block.oreEmerald.blockID);
			xray.add(Block.oreDiamond.blockID);
			xray.add(Block.oreLapis.blockID);
			xray.add(Block.oreRedstone.blockID);
			xray.add(Block.oreRedstoneGlowing.blockID);
			xray.add(Block.oreNetherQuartz.blockID);
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void removeDefaultList()
	{
		try
		{
			Field field = Block.class.getDeclaredField("xrayList");
			field.setAccessible(true);
			ArrayList<Integer> xray = (ArrayList<Integer>) field.get(null);
			xray.remove(Block.oreCoal.blockID);
			xray.remove(Block.oreIron.blockID);
			xray.remove(Block.oreGold.blockID);
			xray.remove(Block.oreEmerald.blockID);
			xray.remove(Block.oreDiamond.blockID);
			xray.remove(Block.oreLapis.blockID);
			xray.remove(Block.oreRedstone.blockID);
			xray.remove(Block.oreRedstoneGlowing.blockID);
			xray.remove(Block.oreNetherQuartz.blockID);
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void rerender(){
		int x = (int) player().posX;
		int y = (int) player().posY;
		int z = (int) player().posZ;
		minecraft().renderGlobal.markBlockRangeForRenderUpdate(x - 200, y - 200, z - 200, x + 200, y + 200, z + 200);
	}
}
