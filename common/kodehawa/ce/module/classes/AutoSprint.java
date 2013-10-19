package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class AutoSprint extends AbstractModule {

	public AutoSprint() {
		super(Category.PLAYER);
		this.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "Auto Sprint";
	}
	
	@Override
	public void tick(){
		getMinecraft().gameSettings.keyBindForward.pressed = true;
		getPlayer().setSprinting(true);
	}
}
