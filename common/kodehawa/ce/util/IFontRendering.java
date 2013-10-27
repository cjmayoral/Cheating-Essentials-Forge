package common.kodehawa.ce.util;

public interface IFontRendering {
	
	void draw(String string, int x, int y);
	void drawWShadow(String string, int x, int y);
	void drawItalic(String string, int x, int y);
	void drawBold(String string, int x, int y);
	void drawColor(String string, int x, int y, int color);
	void drawColorWShadow(String string, int x, int y, int color);
	void drawItalicColor(String string, int x, int y, int color);
	void drawBoldColor(String string, int x, int y, int color);
	
}
