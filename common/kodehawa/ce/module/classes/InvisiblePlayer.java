package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventTick;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class InvisiblePlayer extends ModuleAbstract {

	public InvisiblePlayer() {
		super(Category.PLAYER);
	}

	@Override
	public String getModuleName(){
		return "Invisible Player";
	}
	
	@Override
	@Listener(eventToLoad = EventTick.class)
	public void tick(){
		getPlayer().setInvisible(true);
	}
}
