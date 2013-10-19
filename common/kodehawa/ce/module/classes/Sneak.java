package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Sneak extends AbstractModule {

	public Sneak() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Auto Sneak";
	}

	public void tick(){
		getMinecraft().gameSettings.keyBindSneak.pressed = true;
	}
	
	public void disable(){
		getMinecraft().gameSettings.keyBindSneak.pressed = false;
	}
}
