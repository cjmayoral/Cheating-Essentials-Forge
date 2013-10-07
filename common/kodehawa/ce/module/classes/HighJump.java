package common.kodehawa.ce.module.classes;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class HighJump extends ModuleAbstract {

	public HighJump() {
		super(Category.PLAYER);
	}
	
	@Override
	public String getModuleName(){
		return "High Jump";
	}
	
	@Override
	public void enable(){
		getPlayer().addPotionEffect(new PotionEffect(Potion.jump.getId(), 9999999, 2));
	}
	
	@Override
	public void disable(){
		getPlayer().removePotionEffect(Potion.jump.getId());
	}
}
