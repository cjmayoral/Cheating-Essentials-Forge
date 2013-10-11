package common.kodehawa.ce.commands;

import org.lwjgl.input.Keyboard;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.man.ModuleManager;

public class CommandSMKeybind extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "smkey";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "/smkey add <key> || /smkey delete <key>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
			if(astring[0].equalsIgnoreCase("add")){
				for(ModuleAbstract m : ModuleManager.instance().avModules){
					if(astring[1].equalsIgnoreCase(m.getModuleName().replaceAll(" ", ""))){
						int i = Keyboard.getKeyIndex(astring[2]);
						System.out.println(astring[0]+" "+astring[1]+" "+astring[2]);
						if(i != Keyboard.KEY_NONE){
							m.setKeybinding(i); break;
						}
					}
				}
				
			}
			else if(astring[0].equalsIgnoreCase("delete")){
				for(ModuleAbstract m : ModuleManager.instance().avModules){
					if(astring[1].equalsIgnoreCase(m.getModuleName().replaceAll(" ", ""))){
						m.setKeybinding(0);
					}
				}
			}
		}
	}
