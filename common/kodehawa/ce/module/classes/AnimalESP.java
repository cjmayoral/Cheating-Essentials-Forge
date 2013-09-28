package common.kodehawa.ce.module.classes;

import net.minecraft.entity.EntityLiving;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.GLHelper;

public class AnimalESP extends ModuleAbstract {

	public AnimalESP() {
		super(Category.RENDER);
		this.setRender(true);
	}

	@Override
	public String getModuleName(){
		return "Entity Finder";
	}
	
	@Override
	public void doRender(){
		for(Object o : getWorld().loadedEntityList){
			if(o instanceof EntityLiving){
				EntityLiving living = (EntityLiving)o;
				double x = living.lastTickPosX + (living.posX - living.lastTickPosX);
				double y = living.lastTickPosY + (living.posY - living.lastTickPosY);
				double z = living.lastTickPosZ + (living.posZ - living.lastTickPosZ);
				GLHelper.startDrawingEntityESPs(x, y, z, living, living.height - 0.1, living.width - 0.1);
			}
		}
	}
}
