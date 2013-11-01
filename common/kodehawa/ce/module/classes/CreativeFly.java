package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class CreativeFly extends AbstractModule {

	public CreativeFly() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Creative Fly";
	}
	
	@Override
	public String showHelp(){
		return "Fly like in creative mode!";
	}
	
	@Override
	public void enable(){
		player.capabilities.allowFlying = true;
		player.sendPlayerAbilities();
	}

	@Override
	public void disable(){
		player.capabilities.allowFlying = false;
		player.sendPlayerAbilities();
	}
}
