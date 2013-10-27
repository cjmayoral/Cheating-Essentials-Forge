package common.kodehawa.ce.module.classes;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class InvisiblePlayer extends AbstractModule {

	public InvisiblePlayer() {
		super(Category.PLAYER);
		super.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "Invisible Player";
	}

	@Override
	public String showHelp(){
		return "Makes the player... invisible :)";
	}
	
	@Override
	public void tick(){
		getPlayer().setInvisible(true);
	}
	
	public void disable(){
		getPlayer().setInvisible(false);
	}
}
