package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class WaterWalk extends ModuleAbstract {

	public WaterWalk() {
		super(Category.WORLD);
		this.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "Water Walk";
	}
	
	@Override
	public void tick(){
		if(getPlayer().isInWater()){
			getMinecraft().gameSettings.keyBindJump.pressed = true;
		}
	}
}
