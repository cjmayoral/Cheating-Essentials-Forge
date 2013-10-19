package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class MCUtil_AdvancedTooltips extends AbstractModule {

	public MCUtil_AdvancedTooltips() {
		super(Category.UTILS);
	}
	
	public String getModuleName(){
		return "Advanced Tooltips";
	}

	public void enable(){
		getMinecraft().gameSettings.advancedItemTooltips = !getMinecraft().gameSettings.advancedItemTooltips;
	}
}
