package common.kodehawa.ce.commands;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.util.ChatMessageComponent;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.man.ModuleManager;

public class CommandModuleList extends CommandBase {

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "modulelist";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/modulelist";
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		for(ModuleAbstract module : ModuleManager.instance().avModules){
			icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Module: "+module.getModuleName() + " - Key: ["+Keyboard.getKeyName(module.getKeybind())+"]"));
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
