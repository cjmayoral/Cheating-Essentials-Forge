package common.kodehawa.ce.module.classes;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.*;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class Event_NoFall extends ModuleAbstract {

	public Event_NoFall() {
		super(Category.WORLD);
		this.setForgeEvent(true);
	}
	
	@Override
	public String getModuleName(){
		return "Event No Fall";
	}

	@ForgeSubscribe
	public void onEvent(LivingFallEvent evt){
		if(evt.isCancelable()){
			evt.setCanceled(true);
		}
	}
}
