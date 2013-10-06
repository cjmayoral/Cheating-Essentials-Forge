package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class CreativeFly extends ModuleAbstract {

	public CreativeFly() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Creative Fly";
	}
	
	@Override
	public void enable(){
		getPlayer().capabilities.allowFlying = true;
		getPlayer().sendPlayerAbilities();
	}

	@Override
	public void disable(){
		getPlayer().capabilities.allowFlying = false;
		getPlayer().sendPlayerAbilities();
	}
}
