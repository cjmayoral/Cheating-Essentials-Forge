package com.kodehawa.ce.forge.tick;

import java.util.EnumSet;

import com.kodehawa.ce.event.EventHandler;
import com.kodehawa.ce.event.events.EventTick;
import com.kodehawa.ce.util.KeyboardListener;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandler implements IScheduledTickHandler {

	volatile static TickHandler instance;
	
	public TickHandler( ){
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
		if( FMLClientHandler.instance().getClient().theWorld != null ){
			EventHandler.getInstance().call(new EventTick(this));
		    KeyboardListener.getInstance().handleKeys();
			//EventHandler.getInstance().call(new EventKey(this, Keyboard.getEventKey()));
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {}
		
	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT, TickType.RENDER, TickType.WORLD);
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public int nextTickSpacing() {
		return 0;
	}
	
	public static TickHandler instance(){
		if(instance == null){
			instance = new TickHandler();
		}
		return instance;
	}
}
