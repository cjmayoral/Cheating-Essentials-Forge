package common.kodehawa.ce.module.man;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import com.google.common.collect.Lists;
import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.module.classes.*;
import common.kodehawa.ce.module.core.ModuleAbstract;

public class ModuleManager {

	private static volatile ModuleManager instance = new ModuleManager();
	public List<ModuleAbstract> avModules = Lists.newArrayList();
	
	public ModuleManager(){
		loadClasses();
		DynamicLogger.instance().writeLog("Loaded "+avModules.size()+" modules in Cheating Essentials" , Level.INFO);
	}
	
	public void loadClasses(){
		addModule(new Fly()); addModule(new DynamicFly()); addModule(new FastPlace());
		addModule(new Fullbright()); addModule(new HighJump()); addModule(new Sprint());
		addModule(new FastBreak()); addModule(new Step()); addModule(new WaterWalk());
		addModule(new MCUtil_ReloadChunks()); addModule(new AutoRespawn()); addModule(new EvtNoFall());
		addModule(new NoFall()); addModule(new CreativeFly());
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
	}
	
	public static ModuleManager instance(){
		return instance;
	}
}
