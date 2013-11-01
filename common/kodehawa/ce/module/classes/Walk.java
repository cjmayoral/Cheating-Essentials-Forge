package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Walk extends AbstractModule {

	public Walk() {
		super(Category.PLAYER);
		this.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "Auto Walk";
	}
	
	@Override
	public String showHelp(){
		return "Makes the player to walk automatically.";
	}
	
	public void tick(){
		minecraft.gameSettings.keyBindForward.pressed = true;
	}
	
	public void disable(){
		minecraft.gameSettings.keyBindForward.pressed = false;
	}
}
