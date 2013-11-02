package common.kodehawa.ce.module.classes;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class HighJump extends AbstractModule {

	public HighJump() {
		super(Category.PLAYER);
	}
	
	@Override
	public String getModuleName(){
		return "High Jump";
	}
	
	@Override
	public String showHelp(){
		return "Jump higher!";
	}
	
	@Override
	public void enable(){
		player().addPotionEffect(new PotionEffect(Potion.jump.getId(), 9999999, 2));
	}
	
	@Override
	public void disable(){
		player().removePotionEffect(Potion.jump.getId());
	}
}
