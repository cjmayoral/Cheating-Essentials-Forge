package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventTick;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class AutoRespawn extends ModuleAbstract {

	public AutoRespawn() {
		super(Category.WORLD);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Auto Respawn";
	}
	
	@Override
	@Listener(eventToLoad = EventTick.class)
	public void tick(){
		if(getPlayer().isDead){
			getPlayer().respawnPlayer();
		}
	}

}
