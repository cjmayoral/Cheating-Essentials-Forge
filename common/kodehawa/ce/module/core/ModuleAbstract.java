package common.kodehawa.ce.module.core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.common.MinecraftForge;

import org.apache.commons.lang3.StringUtils;

import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.module.man.ModuleManager;
import common.kodehawa.ce.util.Tickable;

public abstract class ModuleAbstract implements Tickable {

	public String moduleName, moduleVersion, moduleAuthor;
	public int keybinding;
	public Category cat;
	private boolean state, tick, render, forgeEvt;
	
	public ModuleAbstract(Category category){
		cat = category;
	}
	
	public String getModuleName(){
		return StringUtils.defaultString(moduleName);
	}
	
	public int getKeybind(){
		return keybinding;
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
	
	public void setForgeEvent(boolean state){
		forgeEvt = state;
	}
	
	public boolean getForgeEvent(){
		return forgeEvt;
	}
	
	public void setRender(boolean state){
		render = state;
	}

	public boolean isActive(){
		return state;
	}

	public Category getCategory(){
		return cat;
	}

	public boolean getTick(){
		return tick;
	}
	
	public boolean getRender(){
		return render;
	}
	
	public void toggle(){
		state = !state;
		//System.out.println("Module toggled! "+this);
		if(!isActive()){
			enable();
			if(getTick()){
				ModuleManager.instance().addTick(this);
				tick();
			}
			if(getRender()){
				doRender();
			}
			if(getForgeEvent()){
				MinecraftForge.EVENT_BUS.register(this);
			}
		}
		else{
			disable();
			ModuleManager.instance().removeTick(this);
			if(getForgeEvent()){
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}
	}
	
	public Minecraft getMinecraft(){
		return Minecraft.getMinecraft();
	}
	
	public EntityClientPlayerMP getPlayer(){
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
