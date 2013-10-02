package common.kodehawa.ce.module.core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.common.MinecraftForge;

import org.apache.commons.lang3.StringUtils;

import common.kodehawa.ce.mevents.Event;
import common.kodehawa.ce.mevents.EventManager;
import common.kodehawa.ce.mevents.Listener;
import common.kodehawa.ce.mevents.classes.EventRender;
import common.kodehawa.ce.mevents.classes.EventTick;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.Tickable;

public abstract class ModuleAbstract implements Listener {

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
		if(!isActive()){
			enable();
			if(getTick()){
				EventManager.instance().registerListener(EventTick.class, this);
			}
			if(getRender()){
				EventManager.instance().registerListener(EventRender.class, this);
			}
			if(getForgeEvent()){
				MinecraftForge.EVENT_BUS.register(this);
			}
		}
		else{
			disable();
			if(getTick()){
			EventManager.instance().unregisterListener(EventTick.class, this);
			}
			if(getForgeEvent()){
				MinecraftForge.EVENT_BUS.unregister(this);
			}
			if(getRender()){
				EventManager.instance().unregisterListener(EventRender.class, this);
			}
		}
	}
	
	@Override
	public void onEvent(Event event){
		if(event instanceof EventTick){
			tick();
		}
		if(event instanceof EventRender){
			doRender();
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
