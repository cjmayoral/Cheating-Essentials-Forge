package common.kodehawa.ce.module.classes;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class FastBreak extends AbstractModule {

	public FastBreak() {
		super(Category.WORLD);
	}
	
	@Override
	public String getModuleName(){
		return "Fast Break";
	}
	
	@Override
	public String showHelp(){
		return "Applies Haste III for help the player to break blocks faster. Works in MP";
	}
	
	@Override
	public void enable(){
		player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 9999999));
	}
	
	@Override
	public void disable(){
		player.removePotionEffect(Potion.digSpeed.getId());
	}
}
