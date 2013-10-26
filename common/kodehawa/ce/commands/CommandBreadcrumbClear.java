package common.kodehawa.ce.commands;

import common.kodehawa.ce.module.classes.Breadcrumb;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandBreadcrumbClear extends CommandBase {

	@Override
	public String getCommandName() {
		return "ceclearbreadcrumb";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return null;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		Breadcrumb.positionsList.clear();
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
