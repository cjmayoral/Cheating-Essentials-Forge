package common.kodehawa.ce.tick;

import java.util.EnumSet;

import common.kodehawa.ce.module.man.ModuleManager;
import common.kodehawa.ce.util.Keybinding;
import common.kodehawa.ce.util.ITickable;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandler implements IScheduledTickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		Keybinding.instance().handle();
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		for(ITickable tick : ModuleManager.instance().tick){
			tick.tick();
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
		return 0;
	}
}
