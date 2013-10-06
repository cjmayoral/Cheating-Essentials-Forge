package common.kodehawa.ce.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.man.ModuleManager;

public class ConfigManager {

	private static ConfigManager instance = new ConfigManager();
	public boolean universalDebug = false;
	private File keybindConfig = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEKeybind.txt");
	private File debugConfig = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEDebug.txt");
	
	public ConfigManager() {
		write();
		readDebugConfig();
		readKeybindConfig();
	}
	
	public void writeKeybindConfig(){
		DynamicLogger.instance().writeLog("[CM] Writting Keybinding Configuration File...", Level.INFO);
		try{
			FileWriter filewriter = new FileWriter(keybindConfig);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			for(ModuleAbstract module : ModuleManager.instance().avModules){
				String s = Keyboard.getKeyName(module.getKeybind());
			    bufferedwriter.write(/* 0 */"ce_key:" + /* 1 */module.getModuleName().toLowerCase().replace(" ", "") + ":" + /* 2 */s +"\r\n");
			}
			bufferedwriter.close();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public void readKeybindConfig(){
		try {
			DynamicLogger.instance().writeLog("[CM] Reading Keybinding Configuration File...", Level.INFO);
			FileInputStream imputstream = new FileInputStream(keybindConfig.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(imputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String key;
			while((key = bufferedreader.readLine()) != null){
				String line = key.trim();
				String[] string = line.split(":");
				String module1 = string[1];
				int keybinding = Keyboard.getKeyIndex(string[2].toUpperCase());
				for(ModuleAbstract module : ModuleManager.instance().avModules){
					if(module1.equalsIgnoreCase(module.getModuleName().toLowerCase().replace(" ", ""))){
						module.setKeybinding(keybinding);
						if(universalDebug){
							DynamicLogger.instance().writeLog("[CM] Binded: "+module.getModuleName()+" | "+Keyboard.getKeyName(keybinding), Level.INFO); break;
						}
					}
					else{
						if(universalDebug){
							DynamicLogger.instance().writeLog("[CM] Failed to recognize module: "+string[1]+" || Key: "+string[2], Level.WARNING); break;
						}
					}
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeDebugConfig(){
		BufferedWriter bufferedwriter = null;
		try{
			FileWriter filewriter = new FileWriter(debugConfig);
			bufferedwriter = new BufferedWriter(filewriter);
			String s = String.valueOf(universalDebug);
			bufferedwriter.write("debug:" + s);
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally{
			if(bufferedwriter != null){
				try {
					bufferedwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void readDebugConfig(){
		FileInputStream imputstream;
		try {
			imputstream = new FileInputStream(debugConfig.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(imputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String value;
			while((value = bufferedreader.readLine()) != null){
				String line = value.trim();
				String[] values = line.split(":");
				String value1 = values[1];
				try{
					//System.out.println(value1);
					if(value1.equalsIgnoreCase("true") || value1.equalsIgnoreCase("false")){
						universalDebug = Boolean.parseBoolean(value1);
					}
					else{
						DynamicLogger.instance().writeLog("[CM] Can't recognize boolean: "+value1, Level.WARNING);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			bufferedreader.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void write(){
		if(!keybindConfig.exists()){
			keybindConfig.getParentFile().mkdirs();
			try { keybindConfig.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
			writeKeybindConfig();
		}
		if(!debugConfig.exists()){
			debugConfig.getParentFile().mkdirs();
			try{ debugConfig.createNewFile(); } catch(Exception e){ e.printStackTrace(); }
			writeDebugConfig();
		}
	}
	public static ConfigManager instance(){
		return instance;
	}
}
