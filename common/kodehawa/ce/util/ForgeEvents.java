package common.kodehawa.ce.util;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

import common.kodehawa.ce.event.EventHandler;
import common.kodehawa.ce.event.events.EventRender;

public class ForgeEvents {

	//Should be in renderHand?
	@ForgeSubscribe(priority=EventPriority.HIGHEST)
	public void onRenderWorldLastEvent(RenderWorldLastEvent evt){
		EventHandler.getInstance().call(new EventRender(this));
	}
}
