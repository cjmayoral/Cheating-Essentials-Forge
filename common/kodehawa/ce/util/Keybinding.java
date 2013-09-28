package common.kodehawa.ce.util;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.man.ModuleManager;

public class Keybinding {

	private volatile static Keybinding instance = new Keybinding();
	boolean[] mapping = new boolean[256];
	
	public Keybinding(){
		ModuleManager.getKey();
		handle();
	}
	
	public void handle(){
		for(ModuleAbstract module : ModuleManager.instance().avModules){
			if(Keyboard.isKeyDown(module.getKeybind())){
				module.toggle(); break;
			}
		}
	}
	
	public boolean getPressedKey(int key){
			if(Minecraft.getMinecraft().currentScreen != null){
				return false;
			}
			else if(Keyboard.isKeyDown(key) != mapping[key]){
				return mapping[key] != mapping[key];
			}
			else{
				return false;
			}
		}
	
	public static Keybinding instance(){
		return instance;
	}
}