package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.reeszrbteam.ce.gui.click.YouAlwaysWinClickGui;

public class Gui extends AbstractModule {

	
	public Gui() {
		super(Category.NONE);
		this.setKeybinding(Keyboard.KEY_G);
	}
	
	@Override
	public void enable(){
		getMinecraft().displayGuiScreen(new YouAlwaysWinClickGui());
	}
	
	@Override
	public void disable(){
		getMinecraft().displayGuiScreen(new YouAlwaysWinClickGui());
	}
}
