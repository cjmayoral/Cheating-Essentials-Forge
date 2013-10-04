package common.kodehawa.ce.module.core;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraftforge.common.MinecraftForge;

import org.apache.commons.lang3.StringUtils;

import common.kodehawa.ce.event.EventManager;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.Tickable;

public abstract class ModuleAbstract /*implements Listener*/ {

	public String moduleName, moduleVersion, moduleAuthor;
	public int keybinding;
	public Category cat;
	private boolean state, forgeEvt;
	
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
	
	public void setForgeEvent(boolean state){
		forgeEvt = state;
	}
	
	public boolean getForgeEvent(){
		return forgeEvt;
	}
	

	public boolean isActive(){
		return state;
	}

	public Category getCategory(){
		return cat;
	}
	public void toggle(){
		state = !state;
		if(!isActive()){
			enable();
			EventManager.instance().register(this);
			if(getForgeEvent()){
				MinecraftForge.EVENT_BUS.register(this);
			}
		}
		else{
			disable();
			EventManager.instance().unregister(this);
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
