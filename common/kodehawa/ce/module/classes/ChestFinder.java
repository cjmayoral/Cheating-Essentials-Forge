package common.kodehawa.ce.module.classes;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.GLHelper;

public class ChestFinder extends ModuleAbstract {

	public ChestFinder() {
		super(Category.RENDER);
		this.setRender(true);
	}

	@Override
	public String getModuleName(){
		return "Chest Finder";
	}
	
	@Override
	public int getKeybind(){
		return Keyboard.KEY_N;
	}
	
	@Override
	public void doRender(){
		for(Object o : getWorld().loadedEntityList){
			if(o instanceof TileEntityChest){
				TileEntityChest c = (TileEntityChest)o;
			    draw(c, c.xCoord, c.yCoord, c.zCoord, c.prevLidAngle);
		    }
			if(o instanceof TileEntityEnderChest){
				TileEntityEnderChest c1 = (TileEntityEnderChest)o;
			    draw(c1, c1.xCoord, c1.yCoord, c1.zCoord, c1.prevLidAngle);
		    }
		}
	}
	
	public void draw(TileEntityChest c, double x, double y, double z, float f1){
		if(c.xCoord == 0 && c.yCoord == 0 && c.zCoord == 0){
			getMinecraft().entityRenderer.disableLightmap(f1);
			GLHelper.startDrawingESPs(x - RenderManager.renderPosX, y - RenderManager.renderPosY, z - RenderManager.renderPosZ, 1.5F, 0.1F, 0.9F);
			getMinecraft().entityRenderer.enableLightmap(f1);
		}
	}
	
    public void draw(TileEntityEnderChest c, double x, double y, double z, float f1){
		if(c.xCoord == 0 && c.yCoord == 0 && c.zCoord == 0){
			getMinecraft().entityRenderer.disableLightmap(f1);
			GLHelper.startDrawingESPs(x - RenderManager.renderPosX, y - RenderManager.renderPosY, z - RenderManager.renderPosZ, 1.5F, 0.1F, 0.9F);
			getMinecraft().entityRenderer.enableLightmap(f1);
		}
	}
}
