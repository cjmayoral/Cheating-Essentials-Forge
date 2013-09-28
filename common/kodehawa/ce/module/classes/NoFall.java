package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.packet.Packet13PlayerLookMove;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class NoFall extends ModuleAbstract {

	public NoFall() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "No Fall";
	}
	
	@Override
	public int getKeybind(){
		return Keyboard.KEY_V;
	}
	
	@Override
	public void tick(){
		getPlayer().sendQueue.addToSendQueue(new Packet13PlayerLookMove(getPlayer().motionX, -999.0D, -999.0D, getPlayer().motionZ,
				getPlayer().rotationYaw, getPlayer().rotationPitch, !getPlayer().onGround));
	}
}
