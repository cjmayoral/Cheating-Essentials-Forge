package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Fullbright extends AbstractModule {

	public Fullbright() {
		super(Category.WORLD);
		this.setKeybinding(Keyboard.KEY_F);
	}

	@Override
	public String getModuleName(){
		return "Fullbright";
	}
	
	@Override
	public String showHelp(){
		return "Makes the world brighter";
	}
	
	@Override
	public void enable(){
		float[] bright = getWorld().provider.lightBrightnessTable;
		for(int i = 0; i < bright.length; i++){
			bright[i] = 1.0F;
		}
	}
	
	@Override
	public void disable(){
		getWorld().provider.registerWorld(getWorld());
	}
}
