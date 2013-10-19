package common.kodehawa.ce.commands;

import common.kodehawa.ce.util.ConfigManager;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

public class CommandAddFriend extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "cefriend";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "add <friend name> or delete <friend name>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		// TODO Auto-generated method stub
		if(astring[0].equalsIgnoreCase("add")){
			for(String string: ConfigManager.instance().friends){
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Added friend: "+astring[1]));
				ConfigManager.instance().friends.add(astring[1]); break;
			}
		}
		if(astring[0].equalsIgnoreCase("delete")){
			for(String string: ConfigManager.instance().friends){
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Removed friend: "+astring[1]));
				ConfigManager.instance().friends.remove(astring[1]); break;
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
