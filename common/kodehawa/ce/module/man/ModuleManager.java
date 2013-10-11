package common.kodehawa.ce.module.man;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;

import com.google.common.collect.Lists;
import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.util.IRenderable;
import common.kodehawa.ce.util.ITickable;

public class ModuleManager {

	private static volatile ModuleManager instance = new ModuleManager();
	public List<ModuleAbstract> avModules = Lists.newArrayList();
	public List<ITickable> tick = Lists.newArrayList();
	public List<IRenderable> render = Lists.newArrayList();

	
	public ModuleManager(){
		load();
		DynamicLogger.instance().writeLog("Loaded "+avModules.size()+" modules in Cheating Essentials" , Level.INFO);
	}

	void load(){
		String packageName = "common.kodehawa.ce.module.classes.";
		String[] moduleClasses = new String[]{"Fly", "DynamicFly", "FastPlace", "Fullbright", "HighJump", "Sprint", "FastBreak", "Step", "WaterWalk",
				"MCUtil_ReloadChunks", "AutoRespawn", "Event_NoFall", "NoFall", "CreativeFly", "ChestFinder", "InvisiblePlayer", "NoWeb", "BlockFinder",
				"AnimalESP", "MCUtil_AdvancedTooltips", "Unpushable", "InfiniteArrow", "Day", "MCUtil_MobHitbox", "XRay" };
		for(int i = 0; i < moduleClasses.length; ++i){
			try {
				Class clazz = Class.forName(packageName+moduleClasses[i]);
				if(clazz.getSuperclass() == ModuleAbstract.class){
					ModuleAbstract instance = (ModuleAbstract) clazz.newInstance();
					addModule(instance);
				}
				else{
					DynamicLogger.instance().writeLog("Not recognized module", Level.INFO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
    public ModuleAbstract getModuleClass(ModuleAbstract m){
    	for(ModuleAbstract m1 : avModules){
			if(m1.getClass().equals(m)){
				return m1;
			}
		}
		return null;
    }
    
    public void getModules(){
    	Collections.unmodifiableList(avModules);
    }
    		    
	public void addModule(ModuleAbstract m){
		avModules.add(m);
		DynamicLogger.instance().writeLog("Loaded Module: "+StringUtils.upperCase(m.getModuleName())+" in Category: "+m.cat+" "+ "[Key: "+Keyboard.getKeyName(m.getKeybind())+"]", Level.INFO);
	}
	
	public static ModuleManager instance(){
		return instance;
	}
}
