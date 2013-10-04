package common.kodehawa.ce.module.classes;

import net.minecraft.server.MinecraftServer;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventTick;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class Fly extends ModuleAbstract {

	public Fly() {
		super(Category.PLAYER);
	}
	
	@Override
	public String getModuleName(){
		return "Fly";
	}
	
	@Override
	public int getKeybind(){
		return Keyboard.KEY_R;
	}
	
	@Override
	public String getModuleVersion(){
		return "1.0";
    }
	
	public void enable(){
		getPlayer().capabilities.isFlying = true;
	}
	
	public void disable(){
		getPlayer().capabilities.isFlying = false;
	}

	@Listener(eventToLoad = EventTick.class)
	public void tick(){
		getPlayer().capabilities.isFlying = true;
	}
}
