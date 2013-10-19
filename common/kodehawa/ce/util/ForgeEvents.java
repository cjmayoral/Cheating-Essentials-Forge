package common.kodehawa.ce.util;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.man.ModuleManager;

public class ForgeEvents {

	@ForgeSubscribe(priority=EventPriority.HIGHEST)
	public void onRenderWorldLastEvent(RenderWorldLastEvent evt){
		for(AbstractModule modules : ModuleManager.instance().avModules){
			if(modules.getRender()){ modules.doRender(); }
		}
	}
}
