package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Unpushable extends AbstractModule {

	public Unpushable() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Unpushable";
	}
	
	@Override
	public String showHelp(){
		return "No more knockback! :)";
	}
	
	@Override
	public void tick(){
		if(getPlayer().hurtResistantTime > 0 && getPlayer().hurtTime > 0){
			getPlayer().motionX = 0;
			getPlayer().motionZ = 0;
		}
	}

}
