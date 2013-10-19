package common.kodehawa.ce.module.classes;

import net.minecraft.client.renderer.entity.RenderManager;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class MCUtil_MobHitbox extends AbstractModule {

	public MCUtil_MobHitbox() {
		super(Category.UTILS);
	}

	@Override
	public String getModuleName(){
		return "Mob Hitbox";
	}
	
	@Override
	public void enable(){
		RenderManager.field_85095_o = true;
	}
	
	@Override
	public void disable(){
		RenderManager.field_85095_o = false;
	}
}
