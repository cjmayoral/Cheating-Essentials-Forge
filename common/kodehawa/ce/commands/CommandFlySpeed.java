package common.kodehawa.ce.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandFlySpeed extends CommandBase {

	@Override
	public String getCommandName() {
		return "flyspeed";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/flyspeed velocity in numbers (since 0.01 to 0.7)";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		float string = Float.parseFloat(astring[0]);
		try{
			if(string < 100F){
				Minecraft.getMinecraft().thePlayer.capabilities.setFlySpeed(string);
			}
			else{
				System.out.println("lalalal");
			}
		}
		catch(Exception e){}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
