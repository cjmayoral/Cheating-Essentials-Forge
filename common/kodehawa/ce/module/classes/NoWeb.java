package common.kodehawa.ce.module.classes;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.reflect.ReflectionHelper;

public class NoWeb extends AbstractModule {

	public NoWeb() {
		super(Category.PLAYER);
		this.setTick(true);
		this.setKeybinding(Keyboard.KEY_NUMPAD5);
	}

	@Override
	public String getModuleName(){
		return "No Web";
	}
	
	@Override
	public String showHelp(){
		return "No more webs annoying you! Removes web slowdown";
	}
	
	@Override
	public void tick(){
		Object o = getPlayer();
		if(o instanceof EntityPlayerSP){
			ReflectionHelper.setField(Entity.class, o, 27, false);
		}
	}
}
