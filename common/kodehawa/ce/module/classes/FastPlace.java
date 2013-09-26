package common.kodehawa.ce.module.classes;

import net.minecraft.client.Minecraft;
import common.kodehawa.ce.module.core.ModuleAbstract;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.reflect.ReflectionHelper;

public class FastPlace extends ModuleAbstract {

	public FastPlace() {
		super(Category.WORLD);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Fast Place";
	}

	@Override
	public void tick(){
		Object o = Minecraft.getMinecraft();
		ReflectionHelper.setField(Minecraft.class, o, "rightClickDelayTimer", 0);
	}
}
