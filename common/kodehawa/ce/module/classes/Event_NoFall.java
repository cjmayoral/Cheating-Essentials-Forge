package common.kodehawa.ce.module.classes;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.*;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Event_NoFall extends AbstractModule {

	public Event_NoFall() {
		super(Category.WORLD);
		this.setForgeEvent(true);
	}
	
	@Override
	public String getModuleName(){
		return "Event No Fall";
	}
	
	@Override
	public String showHelp(){
		return "Removes fall damage to ALL entities";
	}

	@ForgeSubscribe
	public void onEvent(LivingFallEvent evt){
		if(evt.isCancelable()){
			evt.setCanceled(true);
		}
	}
}
