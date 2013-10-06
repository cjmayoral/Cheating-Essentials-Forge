package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventTick;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class Unpushable extends ModuleAbstract {

	public Unpushable() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Unpushable";
	}
	
	@Override
	public void tick(){
		if(getPlayer().hurtResistantTime > 0 && getPlayer().hurtTime > 0){
			getPlayer().motionX = 0;
			getPlayer().motionZ = 0;
		}
	}

}
