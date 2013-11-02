package common.kodehawa.ce.module.classes;

import net.minecraft.entity.Entity;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.reflect.ReflectionHelper;

public class Step extends AbstractModule {

	public Step() {
		super(Category.WORLD);
		this.setTick(true);
	}
	
	public static float DEFAULT_STEP_HEIGHT = 1.0F;
	
	@Override
	public String getModuleName(){
		return "Step";
	}

	@Override
	public String showHelp(){
		return "Makes the player takes a entire block or more blocks as a slab, for jump automatically";
	}
	
	@Override
	public void tick(){
		Object o = player();
		ReflectionHelper.setField(Entity.class, o, 42, DEFAULT_STEP_HEIGHT);
	}
}
