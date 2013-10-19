package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class InvisiblePlayer extends AbstractModule {

	public InvisiblePlayer() {
		super(Category.PLAYER);
	}

	@Override
	public String getModuleName(){
		return "Invisible Player";
	}
	
	@Override
	public void tick(){
		getPlayer().setInvisible(true);
	}
}
