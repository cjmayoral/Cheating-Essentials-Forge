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
		Object o = getPlayer();
		getPlayer().jumpMovementFactor = 0.4F;
		ReflectionHelper.setField(EntityLivingBase.class, o, 56 /* landMovementFactor */, 0.4F);
		getPlayer().motionX = 0;
		getPlayer().motionY = 0;
		getPlayer().motionZ = 0;
		getPlayer().jumpMovementFactor *= 3;
		
		if(getMinecraft().gameSettings.keyBindJump.pressed){
			getPlayer().motionY += 1;
		}
		if(getMinecraft().gameSettings.keyBindSneak.pressed){
			getPlayer().motionY -= 1;
		}
	}
}
