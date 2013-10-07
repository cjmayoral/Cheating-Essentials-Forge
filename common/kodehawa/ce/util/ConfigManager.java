package common.kodehawa.ce.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Lists;
import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.man.ModuleManager;

public class ConfigManager {

	private static ConfigManager instance = new ConfigManager();
	private File keybindConfig = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEKeybind.txt");
	private File debugConfig = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEDebug.txt");
	private File friendConfig = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEFriends.txt");
	private File enemyConfig = new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEEnemies.txt");
	public ArrayList<String> friends = Lists.newArrayList();
	public ArrayList<String> enemies = Lists.newArrayList();
	public boolean universalDebug = false;

	public ConfigManager() {
		write();
		readDebugConfig();
		readKeybindConfig();
		addDefaultFriends();
		readFriendsConfig();
	}
	
	public void writeKeybindConfig(){
		DynamicLogger.instance().writeLog("[CM] Writting Keybinding Configuration File...", Level.INFO);
		try{
			FileWriter filewriter = new FileWriter(keybindConfig);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			for(ModuleAbstract module : ModuleManager.instance().avModules){
				String s = Keyboard.getKeyName(module.getKeybind());
			    bufferedwriter.write(/* 0 */"ce_key:" + /* 1 */module.getModuleName().toLowerCase().replaceAll(" ", "") + ":" + /* 2 */s +"\r\n");
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
				String keybinding = string[2].toUpperCase();
				for(ModuleAbstract module : ModuleManager.instance().avModules){
					if(module1.equalsIgnoreCase(module.getModuleName().toLowerCase().replaceAll(" ", ""))){
						module.setKeybinding(Keyboard.getKeyIndex(keybinding));
						int newkey = Keyboard.getKeyIndex(keybinding);
						if(universalDebug){
							DynamicLogger.instance().writeLog("[CM] Binded: "+module.getModuleName()+" | "+Keyboard.getKeyName(newkey), Level.INFO); break;
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
	
	public void writeFriendsConfig(){
		try{
			FileWriter filewriter = new FileWriter(friendConfig);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			for(String s : friends){
				bufferedwriter.write(s+"\r\n");
			}
			bufferedwriter.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void readFriendsConfig(){
		DynamicLogger.instance().writeLog("[CM] Loading Friend Config File...", Level.INFO);
		try{
			FileInputStream imputstream = new FileInputStream(friendConfig.getAbsolutePath());
			DataInputStream datastream = new DataInputStream(imputstream);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(datastream));
			String s;
			while((s = bufferedreader.readLine()) != null){
				friends.add(s);
			}
			bufferedreader.close();
		}
		catch(Exception e){
		}
	}
	
	public void writeDebugConfig(){
		try{
			FileWriter filewriter = new FileWriter(debugConfig);
			BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
			String s = String.valueOf(universalDebug);
			bufferedwriter.write("debug:" + s);
			bufferedwriter.close();
		}
		catch(Exception exception){
			exception.printStackTrace();
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
		if(!friendConfig.exists()){
			friendConfig.getParentFile().mkdirs();
			try{ friendConfig.createNewFile(); } catch(Exception e){ e.printStackTrace(); }
			writeFriendsConfig();
		}
	}
	
	private void addDefaultFriends(){
		friends.add("Kodehawa");
		friends.add("DCK1998");
	}
	
	public static ConfigManager instance(){
		return instance;
	}
}
