package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventTick;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class DynamicFly extends ModuleAbstract {

	public DynamicFly() {
		super(Category.PLAYER);
	}

	@Override
	public String getModuleName(){
		return "Dynamic Fly";
	}
	
	@Override
	public String getModuleVersion(){
		return "1.0";
    }
	
	@Override 
	@Listener(eventToLoad = EventTick.class)
	public void tick(){
		getPlayer().jumpMovementFactor = 0;
		
		getPlayer().motionX = 0;
		getPlayer().motionY = 0;
		getPlayer().motionZ = 0;
		
		if(getMinecraft().gameSettings.keyBindJump.pressed){
			getPlayer().motionY += 1;
		}
		if(getMinecraft().gameSettings.keyBindSneak.pressed){
			getPlayer().motionY += 1;
		}
		
		getPlayer().jumpMovementFactor *= 3;
	}
}
