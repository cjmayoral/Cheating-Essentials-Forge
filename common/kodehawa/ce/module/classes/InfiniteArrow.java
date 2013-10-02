package common.kodehawa.ce.module.classes;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class InfiniteArrow extends ModuleAbstract {

	public InfiniteArrow() {
		super(Category.PLAYER);
		this.setForgeEvent(true);
	}

	public String getModuleName(){
		return "Infinite Arrows";
	}
	
	@ForgeSubscribe
	public void removeLooseArrows(ArrowLooseEvent evt){
		if(evt.isCancelable()){
			evt.setCanceled(true);
		}
	}
}
