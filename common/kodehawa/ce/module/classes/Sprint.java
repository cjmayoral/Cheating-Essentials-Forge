package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Sprint extends AbstractModule {

	public Sprint() {
		super(Category.PLAYER);
		super.setTick(true);
		this.setKeybinding(Keyboard.KEY_H);
	}

	@Override
	public String getModuleName(){
		return "Sprint";
	}
	
	@Override
	public String showHelp(){
		return "Sprints automatically when you should be walking.";
	}
	
	@Override
	public void tick(){
		if(player().moveForward > 0){
			player().setSprinting(true);
		}
	}
}
