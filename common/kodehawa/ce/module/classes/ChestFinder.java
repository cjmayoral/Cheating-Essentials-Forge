package common.kodehawa.ce.module.classes;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.GLHelper;
import common.kodehawa.reeszrbteam.ce.util.CEUtils;

public class ChestFinder extends AbstractModule {

	public ChestFinder() {
		super(Category.RENDER);
		this.setRender(true);
		this.setKeybinding(Keyboard.KEY_N);
	}

	@Override
	public String getModuleName(){
		return "Chest Finder";
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
			    draw2(c1, c1.xCoord, c1.yCoord, c1.zCoord, c1.prevLidAngle);
		    }
		}
	}
	
	public void draw(TileEntityChest c, double x, double y, double z, float f1){
		if(c.xCoord == 0 && c.yCoord == 0 && c.zCoord == 0){
			getMinecraft().entityRenderer.disableLightmap(f1);
			CEUtils.drawESP(x - RenderManager.renderPosX, y - RenderManager.renderPosY, z - RenderManager.renderPosZ, 1.5F, 0.1F, 0.9F);
			getMinecraft().entityRenderer.enableLightmap(f1);
		}
	}
	
    public void draw2(TileEntityEnderChest c, double x, double y, double z, float f1){
		if(c.xCoord == 0 && c.yCoord == 0 && c.zCoord == 0){
			getMinecraft().entityRenderer.disableLightmap(f1);
			CEUtils.drawESP(x - RenderManager.renderPosX, y - RenderManager.renderPosY, z - RenderManager.renderPosZ, 1.5F, 0.1F, 0.9F);
			getMinecraft().entityRenderer.enableLightmap(f1);
		}
	}
}
