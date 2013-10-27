package common.kodehawa.ce.module.classes;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.reflect.ReflectionHelper;

public class FastPlace extends AbstractModule {

	public FastPlace() {
		super(Category.WORLD);
	    this.setTick(true);
		this.setKeybinding(Keyboard.KEY_K);
	}
	
	@Override
	public String getModuleName(){
		return "Fast Place";
	}
	
	@Override
	public String showHelp(){
		return "Makes the player to put blocks fastest than normal in the MC world";
	}

	@Override
	public void tick(){
		Object o = Minecraft.getMinecraft();
		ReflectionHelper.setField(Minecraft.class, o, 47 /*rightClickDelayTimer*/, 0);
	}
}
