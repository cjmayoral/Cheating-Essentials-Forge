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
		if(player().hurtResistantTime > 0 && player().hurtTime > 0){
			player().motionX = 0;
			player().motionZ = 0;
		}
	}

}
