package common.kodehawa.ce.module.classes;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Day extends AbstractModule {

	public Day() {
		super(Category.WORLD);
	}

	@Override
	public String getModuleName(){
		return "Set Day";
	}
	
	@Override
	public String showHelp(){
		return "Sets the Minecraft time to day.s";
	}
	
	public void enable(){
		for(WorldServer worldserver : MinecraftServer.getServer().worldServers){
			worldserver.setWorldTime(200);
		}
	}
}
