package common.kodehawa.ce.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

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
			if(string < 0.7F){
				Minecraft.getMinecraft().thePlayer.capabilities.setFlySpeed(string);
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Set Fly Speed to: "+string));
			}
			else{
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Can't set values higher than 0.7"));
			}
		}
		catch(Exception e){}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
