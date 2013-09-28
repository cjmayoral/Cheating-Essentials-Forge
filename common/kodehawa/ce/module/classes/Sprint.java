package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class Sprint extends ModuleAbstract {

	public Sprint() {
		super(Category.PLAYER);
		this.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "Sprint";
	}
	
	@Override
	public int getKeybind(){
		return Keyboard.KEY_H;
	}
	
	@Override
	public void tick(){
		if(getPlayer().moveForward < 0){
			getPlayer().setSprinting(true);
		}
	}
}
