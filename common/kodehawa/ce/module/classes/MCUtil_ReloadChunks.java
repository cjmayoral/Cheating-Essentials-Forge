package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class MCUtil_ReloadChunks extends AbstractModule {

	public MCUtil_ReloadChunks() {
		super(Category.UTILS);
	}

	@Override
	public String getModuleName(){
		return "Reload Chunks";
	}
	
	@Override
	public void enable(){
		minecraft.renderGlobal.loadRenderers();
	}
}
