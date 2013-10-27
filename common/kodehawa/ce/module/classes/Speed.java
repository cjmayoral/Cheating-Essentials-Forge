package common.kodehawa.ce.module.classes;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.reflect.ReflectionHelper;
import common.kodehawa.ce.util.Beta;

@Beta
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
	
	public void tick(){
		Object o = getPlayer();
		if(getPlayer().onGround && !Minecraft.getMinecraft().gameSettings.keyBindJump.pressed){
			getPlayer().motionX *= 1.5;
			getPlayer().motionZ *= 1.5;
		}
	}
}
