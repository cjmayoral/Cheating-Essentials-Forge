package common.kodehawa.ce.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

/**
 * The interface is useless? YESH :)
 * And the class itself too.
 * @author Kodehawa
 */
public class CEFontRenderer implements IFontRendering {

	private static CEFontRenderer font = new CEFontRenderer();
	private ChatMessageComponent component = new ChatMessageComponent();
		
	public static CEFontRenderer font(){
		return font;
	}

	/**
	 * ALL of them are ALIGNED with the screen
	 */
	
	@Override
	public void draw(String string, int x, int y) {
		Minecraft.getMinecraft().fontRenderer.drawString(string, x / Minecraft.getMinecraft().displayWidth, y / Minecraft.getMinecraft().displayHeight, 0xFFFFFF);
	}

	@Override
	public void drawWShadow(String string, int x, int y) {
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(string, x / Minecraft.getMinecraft().displayWidth, y / Minecraft.getMinecraft().displayHeight, 0xFFFFFF);

	}

	@Override
	public void drawItalic(String string, int x, int y) {
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.ITALIC + string, x / Minecraft.getMinecraft().displayWidth, y / Minecraft.getMinecraft().displayHeight, 0xFFFFFF);
	}

	@Override
	public void drawColor(String string, int x, int y, int color) {
		Minecraft.getMinecraft().fontRenderer.drawString(string, x / Minecraft.getMinecraft().displayWidth, y / Minecraft.getMinecraft().displayHeight, color);
	}

	@Override
	public void drawBold(String string, int x, int y) {
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BOLD + string, x / Minecraft.getMinecraft().displayWidth, y / Minecraft.getMinecraft().displayHeight, 0xFFFFFF);
	}

	@Override
	public void drawColorWShadow(String string, int x, int y, int color) {
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(string, x / Minecraft.getMinecraft().displayWidth, y / Minecraft.getMinecraft().displayHeight, color);
	}
	
	@Override
	public void drawItalicColor(String string, int x, int y, int color) {
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.ITALIC + string, x / Minecraft.getMinecraft().displayWidth, y / Minecraft.getMinecraft().displayHeight, color);
	}

	@Override
	public void drawBoldColor(String string, int x, int y, int color) {
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.BOLD + string, x / Minecraft.getMinecraft().displayWidth, y / Minecraft.getMinecraft().displayHeight, color);
	}
}
