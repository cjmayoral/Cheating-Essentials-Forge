package common.kodehawa.ce.commands;

import common.kodehawa.ce.module.classes.BlockFinder;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

public class CommandBlockESP extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "cebe";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "/ceblockesp add/remove block id";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		// TODO Auto-generated method stub
		if(astring[0].equalsIgnoreCase("add")){
			BlockFinder.espList.add(Integer.parseInt(astring[1]));
		    icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Added to CE BlockESP list: "+astring[1]));
		}
		if(astring[0].equalsIgnoreCase("remove")){
			BlockFinder.espList.remove(Integer.parseInt(astring[1]));
		    icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Removed from CE BlockESP list: "+astring[1]));
		}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

}
