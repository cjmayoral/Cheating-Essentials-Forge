package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Test extends AbstractModule {

	public Test() {
		super(Category.UTILS);
		this.setRender(true);
	}

	public String getModuleName(){
		return "dasdsad";
	}
	
	public void doRender(){
		super.doRender();
	}
}
