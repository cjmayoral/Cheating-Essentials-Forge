package common.kodehawa.ce.gui;

import net.minecraft.client.gui.GuiScreen;

public class CheatingEssentialsGui extends GuiScreen {
	
	@Override
	public void initGui(){
		super.initGui();
	}

	@Override
	public void onGuiClosed(){}
	
	@Override
	public void drawScreen(int x, int y, float f){
		super.drawScreen(x, y, f);
		this.drawBackground(0);
	}
}
