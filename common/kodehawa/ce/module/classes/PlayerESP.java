package common.kodehawa.ce.module.classes;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.AltAxisAlignedBB;
import common.kodehawa.ce.util.EntitySpectator;
import common.kodehawa.ce.util.GLHelper;

public class PlayerESP extends AbstractModule {

	public PlayerESP() {
		super(Category.RENDER);
		super.setRender(true);
	}
	
	public String getModuleName(){
		return "Player ESP";
	}

	public void doRender(){
		if(this.isActive()){
			for(Object o : getWorld().loadedEntityList){
				if(o instanceof EntityPlayer){
					EntityPlayer entityplayer = (EntityPlayer)o;
					if(!(entityplayer instanceof EntitySpectator) && !(entityplayer instanceof EntityClientPlayerMP)){
						double x = entityplayer.lastTickPosX + (entityplayer.posX - entityplayer.lastTickPosX);
						double y = entityplayer.lastTickPosY + (entityplayer.posY - entityplayer.lastTickPosY);
						double z = entityplayer.lastTickPosZ + (entityplayer.posZ - entityplayer.lastTickPosZ);
						drawESP(x, y, z, entityplayer, entityplayer.height - 0.1, entityplayer.width - 0.1);
					}
				}
			}
		}
	}
	
	public void drawESP(double d, double d1, double d2, EntityPlayer ep, double e, double f)
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
