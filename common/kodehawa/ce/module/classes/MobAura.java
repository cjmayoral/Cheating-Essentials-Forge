package common.kodehawa.ce.module.classes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.EntityUtils;
import common.kodehawa.ce.util.Watcher;

public class MobAura extends AbstractModule {

	public MobAura() {
		super(Category.WORLD);
		super.setTick(true);
	}
	
	public String getModuleName(){
		return "Auto Hit";
	}

	@Override
	public void tick(){
		for (int i = 0; i < getMinecraft().theWorld.loadedEntityList.size(); i++)
        {
            Entity ent = (Entity) getMinecraft().theWorld.loadedEntityList.get(i);
            int id = ent.entityId;
            long now = System.currentTimeMillis();
            Watcher tracked = EntityUtils.getLastAffected(id);

            if (tracked != null)
            {
                if (tracked.matches(ent, now))
                {
                    continue;
                }
            }

            EntityUtils.setLastAffected(id, ent);

            if ((ent == getMinecraft().thePlayer) || !(ent instanceof EntityLiving) || ent.isDead)
            {
                continue;
            }

            if ((getPlayer().getDistanceSqToEntity(ent) <= 15.0D) && !ent.isDead && getMinecraft().thePlayer.canEntityBeSeen(ent))
            {
            	getMinecraft().playerController.attackEntity(getMinecraft().thePlayer, ent);
            	getPlayer().swingItem();
            }
        } 
	}
}
