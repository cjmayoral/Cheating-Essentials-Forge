package common.kodehawa.ce.module.core;

import org.apache.commons.lang3.StringUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;

import common.kodehawa.ce.module.enums.Category;

public abstract class ModuleAbstract {

	public String moduleName, moduleVersion, moduleAuthor;
	public int keybinding;
	public Category cat;
	private boolean state, tick, render;
	
	public ModuleAbstract(Category category){
		cat = category;
	}
	
	public String getModuleName(){
		return StringUtils.defaultString(moduleName);
	}
	
	public String getModuleVersion(){
		return StringUtils.defaultString(moduleVersion);
	}
	
	public String getModuleAuth(){
		return StringUtils.defaultString(moduleAuthor);
	}
	
	public void setTick(boolean state){
		tick = state;
	}
	
	public void setRender(boolean state){
		render = state;
	}
	
	public void setKeybinding(int key){
		keybinding = key;
	}
	
	public boolean isToggled(){
		return state;
	}
	
	public int getKeybinding(){
		return keybinding;
	}

	public Category getCategory(){
		return cat;
	}
	
	public String getName(){
		return moduleName;
	}
	
	public String getVersion(){
		return moduleVersion;
	}
	
	public boolean getTick(){
		return tick;
	}
	
	public boolean getRender(){
		return render;
	}
	
	public void toggle(){
		state = !state;
		if(isToggled()){
			enable();
			if(getTick()){
				tick();
			}
			if(getRender()){
				doRender();
			}
		}
		else{
			disable();
		}
	}
	
	public Minecraft getMinecraft(){
		return Minecraft.getMinecraft();
	}
	
	public EntityPlayer getPlayer(){
		return getMinecraft().thePlayer;
	}
	
	public WorldClient getWorld(){
		return getMinecraft().theWorld;
	}
	
	public void enable(){}
	public void disable(){}
	public void doRender(){}
	public void tick(){}
}
