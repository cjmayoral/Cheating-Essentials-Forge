package common.kodehawa.ce.module.classes;

import java.util.Random;

import net.minecraft.entity.projectile.EntityArrow;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class ArrowDodge extends AbstractModule {

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
		for(Object o : getWorld().loadedEntityList){
			if(o instanceof EntityArrow){
				EntityArrow arrow = (EntityArrow)o;
				if(arrow != null && arrow.getDistanceSqToEntity(getPlayer()) == 1.0){
					Random random = new Random();
					arrow.posX = random.nextInt(3000000);
					arrow.posY = random.nextInt(3000000);
					arrow.posZ = random.nextInt(3000000);
				}
		}
		
		}
	}

}
