package common.kodehawa.ce.module.classes;

import java.util.List;
import java.util.logging.Level;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;

import com.google.common.collect.Lists;

import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class XRay extends ModuleAbstract{

	public List<Integer> blocksToRender = Lists.newArrayList();
	public List<Integer> blocksToIgnore = Lists.newArrayList();
	
	public XRay() {
		super(Category.RENDER);
		this.setKeybinding(Keyboard.KEY_X);
		this.setTick(true);
		addDefaultList();
	}

	@Override
	public String getModuleName(){
		return "X-Ray";
	}
	
	@Override
	public void enable(){
		addDefaultList();
		getMinecraft().renderGlobal.loadRenderers();
	}
	
	@Override
	public void disable(){
		getMinecraft().renderGlobal.loadRenderers();
	}
	
	@Override
	public void tick(){}
	
	void addDefaultList(){
		for(Block block : Block.blocksList){
			if(block instanceof BlockOre || block instanceof BlockRedstoneOre){
				if(!blocksToIgnore.contains(block.blockID)){
					blocksToRender.add(block.blockID);
					DynamicLogger.instance().writeLogWithPrefix("<X-Ray>", "Added to default X-Ray list: " + block.getLocalizedName() + " " + "("+block.getUnlocalizedName()+")", Level.INFO, 1);
				}
			}
		}
	}
}
