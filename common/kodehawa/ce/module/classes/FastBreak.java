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
	public void enable(){
		getPlayer().addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 9999999));
	}
	
	@Override
	public void disable(){
		getPlayer().removePotionEffect(Potion.digSpeed.getId());
	}
}
