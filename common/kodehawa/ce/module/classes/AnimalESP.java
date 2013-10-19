package common.kodehawa.ce.module.classes;

import net.minecraft.entity.EntityLiving;

import org.lwjgl.opengl.GL11;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.AltAxisAlignedBB;
import common.kodehawa.ce.util.GLHelper;

public class AnimalESP extends AbstractModule {

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
				drawESP(x, y, z, living, living.height - 0.1, living.width - 0.1);
			}
		}
	}
	
	public void drawESP(double d, double d1, double d2, EntityLiving ep, double e, double f)
	{
	        GL11.glPushMatrix();
	        GL11.glEnable(3042);
	        GL11.glColor4f(0.27F, 0.70F, 0.92F, 0.15F);
	        GL11.glDisable(GL11.GL_TEXTURE_2D);
	        GL11.glDisable(GL11.GL_LIGHTING);
	        GL11.glDisable(GL11.GL_DEPTH_TEST);
	        GL11.glDepthMask(false);
	        GL11.glLineWidth(1.8F);
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	        GL11.glEnable(GL11.GL_LINE_SMOOTH);
	        GLHelper.drawBoundingBox(new AltAxisAlignedBB(d - f, d1 + 0.1, d2 - f, d + f, d1 + e + 0.25, d2 + f));
	        GL11.glColor4f(0.27F, 0.70F, 0.92F, 1.0F);
	        GLHelper.drawOutlinedBoundingBox(new AltAxisAlignedBB(d - f, d1 + 0.1, d2 - f, d + f, d1 + e + 0.25, d2 + f));
	        GL11.glDepthMask(true);
	        GL11.glEnable(GL11.GL_DEPTH_TEST);
	        GL11.glEnable(GL11.GL_TEXTURE_2D);
	        GL11.glEnable(GL11.GL_LIGHTING);
	        GL11.glDisable(GL11.GL_LINE_SMOOTH);
	        GL11.glDisable(3042);
	        GL11.glPopMatrix();
    }
}
