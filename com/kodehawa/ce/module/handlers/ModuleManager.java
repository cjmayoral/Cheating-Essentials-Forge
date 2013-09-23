package com.kodehawa.ce.module.handlers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import net.minecraft.client.renderer.texture.Tickable;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod(modid = "CE-ModuleManager", name = "Cheating Essentials MM",
dependencies = "after:Cheating-Essentials", version = "3.3.3a1")
public final class ModuleManager {

	public HashMap<Class<? extends CheatingEssentialsModule>, String> modulesHash = new HashMap<Class<? extends CheatingEssentialsModule>, String>();
    public volatile List<CheatingEssentialsModule> modules = new CopyOnWriteArrayList<CheatingEssentialsModule>();
    public List<String> enabledModules = new CopyOnWriteArrayList<String>();

    private volatile static ModuleManager instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt){
		ModMetadata modMeta = evt.getModMetadata();
		modMeta.parent = "Cheating-Essentials";    	
	}
	
    public final CheatingEssentialsModule getModuleByClass(final Class module) {
                synchronized (modules) {
                        for (final CheatingEssentialsModule e : modules) {
                                if (e.getClass().equals(module)) {
                                        return e;
                                }
                        }
                }
                return null;
        }

     public final List<CheatingEssentialsModule> getModules() {
                synchronized (modules) {
                        return Collections.unmodifiableList(modules);
                }
        }

 	public static ModuleManager getInstance(){
 		if(instance == null){
 			instance = new ModuleManager();
 		}
 		return instance;
 	}
 	
}

