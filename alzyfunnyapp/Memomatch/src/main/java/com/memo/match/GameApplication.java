package com.memo.match;

import android.app.Application;

import com.memo.match.utils.FontLoader;

public class GameApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		FontLoader.loadFonts(this);

	}
}
