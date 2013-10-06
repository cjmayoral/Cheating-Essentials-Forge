package common.kodehawa.ce.module.classes;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;

import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventTick;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.reflect.ReflectionHelper;

public class NoWeb extends ModuleAbstract {

	public NoWeb() {
		super(Category.PLAYER);
		this.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "No Web";
	}
	
	@Override
	public void tick(){
		Object o = getPlayer();
		if(o instanceof EntityPlayerSP){
			ReflectionHelper.setField(Entity.class, o, 27, false);
		}
	}
}
