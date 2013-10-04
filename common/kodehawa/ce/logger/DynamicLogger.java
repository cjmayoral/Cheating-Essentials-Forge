package common.kodehawa.ce.logger;

import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

/**
 * Logger for print things in console used by a lot of classes, specially {@link CheatingEssentials}
 * This logger provides to the mod a basic funcionality for describe the warning level and the string to print.
 * @author Kodehawa
 */
public class DynamicLogger {

	public static volatile DynamicLogger instance = new DynamicLogger();
	
	public void writeLog(String data, Level level){
		FMLLog.info(data, "Cheating-Essentials");
	}
	
	public static DynamicLogger instance(){
		return instance;
	}
}
