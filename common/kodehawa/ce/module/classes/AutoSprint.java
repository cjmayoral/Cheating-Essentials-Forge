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
	public String showHelp(){
		return "Makes the player sprint automatically (And walk too)";
	}
	
	@Override
	public void tick(){
		minecraft().gameSettings.keyBindForward.pressed = true;
		player().setSprinting(true);
	}
}
