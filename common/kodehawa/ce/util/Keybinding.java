package common.kodehawa.ce.util;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.man.ModuleManager;

public class Keybinding {

	private volatile static Keybinding instance = new Keybinding();
	
	public Keybinding(){
		handle();
	}
	
	public void handle(){
		for(ModuleAbstract module : ModuleManager.instance().avModules){
			if(checkKey(module.getKeybind())){
				module.toggle(); break;
			}
        }
	}
	
	public boolean checkKey( int i ) {
		if (Minecraft.getMinecraft().currentScreen != null) {
			return false;
		}
		if (Keyboard.isKeyDown(i) != keyStates [i]) {
			return keyStates [i] = !keyStates[i];
		} else {
			return false;
		}
	}
	
	private boolean keyStates[] = new boolean[256];
	
	public static Keybinding instance(){
		return instance;
	}
}