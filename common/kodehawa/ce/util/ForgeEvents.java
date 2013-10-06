package common.kodehawa.ce.util;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

import common.kodehawa.ce.module.man.ModuleManager;

public class ForgeEvents {

	@ForgeSubscribe(priority=EventPriority.HIGH)
	public void onRenderWorldLastEvent(RenderWorldLastEvent evt){
		for(IRenderable render : ModuleManager.instance().render){
			render.doRender();
		}
	}
}
