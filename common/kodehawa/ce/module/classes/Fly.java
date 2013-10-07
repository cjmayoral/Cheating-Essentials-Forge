package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class Fly extends ModuleAbstract {

	public Fly() {
		super(Category.PLAYER);
		this.setTick(true);
		this.setKeybinding(Keyboard.KEY_R);
	}
	
	@Override
	public String getModuleName(){
		return "Fly";
	}

	public void enable(){
		getPlayer().capabilities.isFlying = true;
	}
	
	public void disable(){
		getPlayer().capabilities.isFlying = false;
	}

	public void tick(){
		getPlayer().capabilities.isFlying = true;
	}
}
