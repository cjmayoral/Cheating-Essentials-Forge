package common.kodehawa.ce.module.core;

import common.kodehawa.ce.module.enums.Category;

public abstract class ModuleAbstract {

	public String moduleName, moduleVersion, moduleAuthor;
	public int keybinding;
	public Category cat;
	private boolean state, tick, render;
	
	public void setModuleName(String name){
		moduleName = name;
	}
	
	public void setModuleVersion(String version){
		moduleVersion = version;
	}
	
	public void setModuleAuth(String author){
		moduleAuthor = author;
	}
	
	public void setModuleCategory(Category category){
		cat = category;
	}
	
	public void setTick(boolean state){
		tick = state;
	}
	
	public void setRender(boolean state){
		render = state;
	}
	
	public void setKeybinding(int key){
		keybinding = key;
	}
	
	public boolean isToggled(){
		return state;
	}
	
	public int getKeybinding(){
		return keybinding;
	}

	public Category getCategory(){
		return cat;
	}
	
	public String getName(){
		return moduleName;
	}
	
	public String getVersion(){
		return moduleVersion;
	}
	
	public boolean getTick(){
		return tick;
	}
	
	public boolean getRender(){
		return render;
	}
	
	public void toggle(){
		state = !state;
		if(isToggled()){
			enable();
			if(getTick()){
				tick();
			}
			if(getRender()){
				doRender();
			}
		}
		else{
			disable();
		}
	}
	
	public void enable(){}
	public void disable(){}
	public void doRender(){}
	public void tick(){}
}
