package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class AutoRespawn extends AbstractModule {

	public AutoRespawn() {
		super(Category.WORLD);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Auto Respawn";
	}
	
	@Override
	public String showHelp(){
		return "Auto Respawn the player when dead.";
	}
	
	@Override
	public void tick(){
		if(player.isDead){
			player.respawnPlayer();
		}
	}

}
