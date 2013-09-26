package common.kodehawa.ce.module.classes;

import org.apache.commons.lang3.StringUtils;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class Fly extends ModuleAbstract {

	public Fly() {
		super(Category.PLAYER);
		this.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "Fly";
	}
	
	@Override
	public String getModuleVersion(){
		return "1.0";
    }
	
	public void tick(){
		getPlayer().capabilities.isFlying = true;
	}
	
}
