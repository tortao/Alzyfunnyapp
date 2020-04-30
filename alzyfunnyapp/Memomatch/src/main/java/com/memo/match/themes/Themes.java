package com.memo.match.themes;

import android.graphics.Bitmap;

import com.memo.match.common.Shared;
import com.memo.match.utils.Utils;

import java.util.ArrayList;

public class Themes {

	public static String URI_DRAWABLE = "drawable://";

	public static Theme createAnimalsTheme() {
		Theme theme = new Theme();
		theme.id = 1;
		theme.name = "Animals";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_animal";
		theme.tileImageUrls = new ArrayList<String>();
		// 28 drawables
		for (int i = 1; i <= 28; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("animals_%d", i));
		}
		return theme;
	}

	public static Theme createHome_ElectronicsTheme() {
		Theme theme = new Theme();
		theme.id = 2;
		theme.name = "Home_Electronics";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_home_electronics";
		theme.tileImageUrls = new ArrayList<String>();
		// 28 drawables
		for (int i = 1; i <= 28; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("home_electronics_%d", i));
		}
		return theme;
	}

	public static Theme createABCTheme() {
		Theme theme = new Theme();
		theme.id = 3;
		theme.name = "ABC";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_abc";
		theme.tileImageUrls = new ArrayList<String>();
		// 26 drawables
		for (int i = 1; i <= 26; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("abc_%d", i));
		}
		return theme;
	}
	
	public static Bitmap getBackgroundImage(Theme theme) {
		String drawableResourceName = theme.backgroundImageUrl.substring(Themes.URI_DRAWABLE.length());
		int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
		Bitmap bitmap = Utils.scaleDown(drawableResourceId, Utils.screenWidth(), Utils.screenHeight());
		return bitmap;
	}

}
