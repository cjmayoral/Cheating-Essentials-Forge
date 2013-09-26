package common.kodehawa.ce.module.classes;

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
	public void tick(){
		PacketDispatcher.sendPacketToPlayer(new Packet13PlayerLookMove(getPlayer().posX, getPlayer().posY, getPlayer().posZ, -999D, getPlayer().rotationYaw, getPlayer().rotationPitch, false), (Player)getPlayer());
	}
}
