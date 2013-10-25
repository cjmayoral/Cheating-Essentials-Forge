package common.kodehawa.ce.util;

public interface IFontRendering {
	
	public void draw(String string, int x, int y);
	public void drawWShadow(String string, int x, int y);
	public void drawItalic(String string, int x, int y);
	public void drawBold(String string, int x, int y);
	public void drawColor(String string, int x, int y, int color);
	public void drawColorWShadow(String string, int x, int y, int color);
	
}
