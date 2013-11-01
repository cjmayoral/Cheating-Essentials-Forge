package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Fly extends AbstractModule {

	public Fly() {
		super(Category.PLAYER);
		this.setTick(true);
		this.setKeybinding(Keyboard.KEY_R);
	}
	
	@Override
	public String getModuleName(){
		return "Fly";
	}
	
	@Override
	public String showHelp(){
		return "I believe I can fly (8)~";
	}

	public void enable(){
		player.capabilities.isFlying = true;
	}
	
	public void disable(){
		player.capabilities.isFlying = false;
	}

	public void tick(){
		player.capabilities.isFlying = true;
	}
}
