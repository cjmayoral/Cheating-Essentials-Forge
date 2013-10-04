package common.kodehawa.ce.util;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.ForgeSubscribe;

import common.kodehawa.ce.event.EventManager;
import common.kodehawa.ce.event.classes.EventRender;

public class ForgeEvents {

	@ForgeSubscribe
	public void worldTick(RenderWorldLastEvent evt){
		EventManager.instance().call(new EventRender(this));
	}
}
