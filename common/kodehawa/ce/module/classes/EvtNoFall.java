package common.kodehawa.ce.module.classes;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.*;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class EvtNoFall extends ModuleAbstract {

	public EvtNoFall() {
		super(Category.WORLD);
	}
	
	@Override
	public String getModuleName(){
		return "E. No Fall";
	}

	@ForgeSubscribe
	public void onEvent(LivingFallEvent evt){
		if(evt.isCancelable()){
			evt.setCanceled(true);
		}
	}
}
