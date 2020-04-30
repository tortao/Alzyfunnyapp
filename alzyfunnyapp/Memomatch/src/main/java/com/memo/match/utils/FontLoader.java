package com.memo.match.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.widget.TextView;

public class FontLoader {

	public static final int DailyMilk = 0;

	private static SparseArray<Typeface> fonts = new SparseArray<Typeface>();
	private static boolean fontsLoaded = false;

	public static enum Font {
		DailyMilk(FontLoader.DailyMilk, "fonts/DailyMilk.ttf");

		private int val;
		private String path;

		private Font(int val, String path) {
			this.val = val;
			this.path = path;
		}

		public static String getByVal(int val) {
			for (Font font : values()) {
				if (font.val == val) {
					return font.path;
				}
			}
			return null;
		}
	}
	
	public static void loadFonts(Context context) {
		for (int i = 0; i < Font.values().length; i++) {
			fonts.put(i, Typeface.createFromAsset(context.getAssets(), Font.getByVal(i)));
		}
		fontsLoaded = true;
	}



	public static Typeface getTypeface(Context context, Font font) {
		if (!fontsLoaded) {
			loadFonts(context);
		}
		return fonts.get(font.val);
	}


	public static void setTypeface(Context context, TextView[] textViews, Font font) {
		setTypeFaceToTextViews(context, textViews, font, Typeface.NORMAL);
	}


	public static void setBoldTypeface(Context context, TextView[] textViews, Font font) {
		setTypeFaceToTextViews(context, textViews, font, Typeface.BOLD);
	}

	private static void setTypeFaceToTextViews(Context context, TextView[] textViews, Font font, int fontStyle) {
		if (!fontsLoaded) {
			loadFonts(context);
		}
		Typeface currentFont = fonts.get(font.val);

		for (int i = 0; i < textViews.length; i++) {
			if (textViews[i] != null)
				textViews[i].setTypeface(currentFont, fontStyle);
		}
	}

}
