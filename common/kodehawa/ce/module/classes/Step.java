package common.kodehawa.ce.module.classes;

import net.minecraft.entity.Entity;

import common.kodehawa.ce.event.EventManager;
import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventTick;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.reflect.ReflectionHelper;

public class Step extends ModuleAbstract {

	public Step() {
		super(Category.WORLD);
	}
	
	@Override
	public String getModuleName(){
		return "Step";
	}

	@Override
	@Listener(eventToLoad = EventTick.class)
	public void tick(){
		Object o = getPlayer();
		ReflectionHelper.setField(Entity.class, o, "stepHeight", 1.0F);
	}
}
