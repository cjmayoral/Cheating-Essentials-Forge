package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.projectile.EntityArrow;

import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventTick;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class ArrowDodge extends ModuleAbstract {

	public ArrowDodge() {
		super(Category.WORLD);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Arrow Dodge";
	}
	
	@Override
	public int getKeybind(){
		return Keyboard.KEY_B;
	}
	
	public void tick(){
		Object o = getWorld().loadedEntityList;
		if(o instanceof EntityArrow){
		EntityArrow arrow = (EntityArrow)o;
		if(arrow != null && arrow.getDistanceSqToEntity(getPlayer()) == 0.5D){
			getWorld().removeEntityFromWorld(arrow.entityId);
		}
		}
	}

}
