package common.kodehawa.ce.tick;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;

import common.kodehawa.ce.module.man.ModuleManager;
import common.kodehawa.ce.util.Keybinding;
import common.kodehawa.ce.util.Tickable;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandler implements IScheduledTickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		Keybinding.instance().handle();
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if(Minecraft.getMinecraft().theWorld != null)
			for(Tickable t : ModuleManager.instance().tickList){
				t.tick();
			}
	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return EnumSet.of(TickType.CLIENT, TickType.WORLD);
	}

	@Override
	public String getLabel() {
		return "Cheating-Essentials";
	}

	@Override
	public int nextTickSpacing() {
		// TODO Auto-generated method stub
		return 0;
	}


}
