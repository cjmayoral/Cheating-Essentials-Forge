package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class MCUtil_ReloadChunks extends ModuleAbstract {

	public MCUtil_ReloadChunks() {
		super(Category.UTILS);
	}

	@Override
	public String getModuleName(){
		return "Reload Chunks";
	}
	
	@Override
	public void enable(){
		getMinecraft().renderGlobal.loadRenderers();
	}
}
