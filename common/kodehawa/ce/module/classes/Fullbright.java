package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;

public class Fullbright extends ModuleAbstract {

	public Fullbright() {
		super(Category.WORLD);
	}

	@Override
	public String getModuleName(){
		return "Fullbright";
	}
	
	@Override
	public void enable(){
		float[] bright = getMinecraft().theWorld.provider.lightBrightnessTable;
		for(int i = 0; i < bright.length; i++){
			bright[i] = 1.0F;
		}
	}
}
