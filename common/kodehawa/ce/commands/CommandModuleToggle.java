package common.kodehawa.ce.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.man.ModuleManager;

public class CommandModuleToggle extends CommandBase {

	@Override
	public String getCommandName() {
		return "module";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/module <modulenametoenable>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		for(ModuleAbstract module : ModuleManager.instance().avModules){
			if(module.getModuleName().replace(" ", "").equalsIgnoreCase(astring[0])){
				module.toggle(); break;
			}
		}
	}

}
