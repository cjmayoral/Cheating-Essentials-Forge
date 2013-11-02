package common.kodehawa.ce.module.classes;

import net.minecraft.entity.EntityLivingBase;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.reflect.ReflectionHelper;

public class DynamicFly extends AbstractModule {

	public DynamicFly() {
		super(Category.PLAYER);
		this.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "Dynamic Fly";
	}
	
	@Override
	public String showHelp(){
		return "Another way to fly. Also called static fly";
	}
	
	@Override 
	public void tick(){
		Object o = player();
		player().jumpMovementFactor = 0.4F;
		ReflectionHelper.setField(EntityLivingBase.class, o, 56, 0.4F);
		player().motionX = 0;
		player().motionY = 0;
		player().motionZ = 0;
		player().jumpMovementFactor *= 3;
		
		if(minecraft().gameSettings.keyBindJump.pressed){
			player().motionY += 1;
		}
		if(minecraft().gameSettings.keyBindSneak.pressed){
			player().motionY -= 1;
		}
	}
}
