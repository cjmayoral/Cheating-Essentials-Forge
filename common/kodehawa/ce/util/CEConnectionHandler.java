package common.kodehawa.ce.util;

import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.util.EnumChatFormatting;
import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.main.CheatingEssentials;
import common.kodehawa.ce.module.man.ModuleManager;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class CEConnectionHandler implements IConnectionHandler {

	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {
		//Shouldn't print the player name?
		Minecraft.getMinecraft().thePlayer.addChatMessage(EnumChatFormatting.BOLD + "Cheating Essentials ("+CheatingEssentials.mainInstance().modVersion+")"+" loaded succefully. Loaded Modules: "+ModuleManager.instance().avModules.size());
	}
	
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) {
		DynamicLogger.instance().writeInfo("Client (in Internal Server "+ IntegratedServer.class.toString() +") logged in - Cheating Essentials is handling it... (username: "+Minecraft.getMinecraft().thePlayer.username+")");
		//Some methods here.
	}

	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) { return null; }
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {}
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {}
	public void connectionClosed(INetworkManager manager) {}
}
