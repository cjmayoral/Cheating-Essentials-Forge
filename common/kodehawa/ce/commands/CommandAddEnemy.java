package common.kodehawa.ce.commands;

import common.kodehawa.ce.util.ConfigManager;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

public class CommandAddEnemy extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "ceenemy";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "add <enemy name> or delete <enemy name>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(astring[0].equalsIgnoreCase("add")){
			for(String s : ConfigManager.instance().enemies){
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Added enemy: "+astring[1]));
				ConfigManager.instance().enemies.add(astring[1]); break;
			}
		}
		if(astring[0].equalsIgnoreCase("delete")){
			for(String s : ConfigManager.instance().enemies){
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Remove enemy: "+astring[1]));
				ConfigManager.instance().enemies.remove(astring[1]); break;
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
