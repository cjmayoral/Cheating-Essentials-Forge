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
	
	public void tick(){
		getMinecraft().gameSettings.keyBindForward.pressed = true;
	}
	
	public void disable(){
		getMinecraft().gameSettings.keyBindForward.pressed = false;
	}
}
