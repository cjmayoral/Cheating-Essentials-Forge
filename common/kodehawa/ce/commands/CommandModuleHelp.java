package common.kodehawa.ce.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.man.ModuleManager;

public class CommandModuleHelp extends CommandBase {

	@Override
	public String getCommandName() {
		return "modulehelp";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "<name of the mod>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		for(AbstractModule module : ModuleManager.instance().avModules){
			if(astring[0].equalsIgnoreCase(module.getModuleName().replaceAll(" ", ""))){
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Help for module "+module.getModuleName()+": "+module.showHelp()));
			}
		}
	}
	
    public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender) {
        return true;
    }

}
