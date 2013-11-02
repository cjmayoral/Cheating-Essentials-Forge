package common.kodehawa.ce.module.classes;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.reflect.ReflectionHelper;
import common.kodehawa.ce.util.Beta;

public class Speed extends AbstractModule {

	public Speed() {
		super(Category.PLAYER);
		setTick(true);
	}
	
	public String getModuleName(){
		return "Speed";
	}
	
	@Override
	public String showHelp(){
		return "Makes the player to run faster.";
	}
	
	public static double SPEED_VALUE = 1.3;
	
	public void tick(){
		if(player().onGround && !Minecraft.getMinecraft().gameSettings.keyBindJump.pressed){
			player().motionX *= SPEED_VALUE;
			player().motionZ *= SPEED_VALUE;
		}
	}
}
