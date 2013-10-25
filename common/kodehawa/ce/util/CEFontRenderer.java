package common.kodehawa.ce.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ResourceLocation;

/**
 * The interface is useless? YESH :)
 * And the class itself too.
 * @author Kodehawa
 */
public class CEFontRenderer extends FontRenderer implements IFontRendering {

	private static CEFontRenderer font = new CEFontRenderer(Minecraft.getMinecraft().gameSettings, new ResourceLocation("textures/font/ascii.png"), Minecraft.getMinecraft().renderEngine, false);
	
	public CEFontRenderer(GameSettings par1GameSettings, ResourceLocation par2ResourceLocation, TextureManager par3TextureManager, boolean par4) {
		super(par1GameSettings, par2ResourceLocation, par3TextureManager, par4);
	}
	
	private ChatMessageComponent component = new ChatMessageComponent();
	
	public static CEFontRenderer font(){
		return font;
	}

	@Override
	public void draw(String string, int x, int y) {
		super.drawString(string, x, y, 0xFFFFFF);
	}

	@Override
	public void drawWShadow(String string, int x, int y) {
	    super.drawStringWithShadow(string, x, y, 0xFFFFFF);	
	}

	@Override
	public void drawItalic(String string, int x, int y) {
		component.setItalic(true);
		super.drawString(string, x, y, 0xFFFFFF);
	}

	@Override
	public void drawColor(String string, int x, int y, int color) {
		super.drawString(string, x, y, color, false);
	}

	@Override
	public void drawBold(String string, int x, int y) {
		component.setBold(true);
		super.drawString(string, x, y, 0xFFFFFF);
	}

	@Override
	public void drawColorWShadow(String string, int x, int y, int color) {
	    super.drawStringWithShadow(string, x, y, color);	
	}
}
