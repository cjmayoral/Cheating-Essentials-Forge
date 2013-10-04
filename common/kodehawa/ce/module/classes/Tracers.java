package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.event.Listener;
import common.kodehawa.ce.event.classes.EventRender;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class Tracers extends ModuleAbstract {

	public Tracers() {
		super(Category.RENDER);
	}

	@Override
	@Listener(eventToLoad = EventRender.class)
	public void doRender(){
		
	}
}
