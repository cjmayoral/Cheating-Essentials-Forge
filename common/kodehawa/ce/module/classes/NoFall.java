package common.kodehawa.ce.module.classes;

import net.minecraft.network.packet.Packet13PlayerLookMove;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class NoFall extends AbstractModule {

	public NoFall() {
		super(Category.PLAYER);
		this.setTick(true);
		this.setKeybinding(Keyboard.KEY_V);
	}
	
	@Override
	public String getModuleName(){
		return "No Fall";
	}
	
	@Override
	public void tick(){
		getPlayer().sendQueue.addToSendQueue(new Packet13PlayerLookMove(getPlayer().motionX, -999.0D, -999.0D, getPlayer().motionZ,
				getPlayer().rotationYaw, getPlayer().rotationPitch, !getPlayer().onGround));
	}
}
