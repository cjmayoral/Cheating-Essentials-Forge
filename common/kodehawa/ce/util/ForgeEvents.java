package common.kodehawa.ce.util;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;

import common.kodehawa.ce.mevents.EventManager;
import common.kodehawa.ce.mevents.classes.EventRender;

public class ForgeEvents {

	@ForgeSubscribe
	public void worldTick(RenderWorldLastEvent e){
		EventManager.instance().fire(new EventRender(this));
	}
	
}
