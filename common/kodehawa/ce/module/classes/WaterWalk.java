package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventTick;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class WaterWalk extends ModuleAbstract {

	public WaterWalk() {
		super(Category.WORLD);
	}

	@Override
	public String getModuleName(){
		return "Water Walk";
	}
	
	@Override
	public int getKeybind(){
		return Keyboard.KEY_J;
	}
	
	@Override
	@Listener(eventToLoad = EventTick.class)
	public void tick(){
		if(getPlayer().isInWater()){
			getMinecraft().gameSettings.keyBindJump.pressed = true;
		}
	}
}
