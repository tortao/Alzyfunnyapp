package com.memo.match.model;

import android.graphics.Bitmap;

import com.memo.match.common.Shared;
import com.memo.match.themes.Themes;
import com.memo.match.utils.Utils;

import java.util.Map;


public class BoardArrangment {

	// เหมือน {0-2, 4-3, 1-5}
	public Map<Integer, Integer> pairs;
	// เหมือน {0-home_electronics_20, 1-home_electronics_12, 2-home_electronics_20, ...}
	public Map<Integer, String> tileUrls;

	/**
	 * 
	 * @param id
	 *            id คือตัวเลขระหว่าง 0 ถึงจำนวนไทล์ที่เป็นไปได้ของ
	 *  ชุดรูปแบบนี้
	 * @return The Bitmap of the tile
	 */
	public Bitmap getTileBitmap(int id, int size) {
		String string = tileUrls.get(id);
		if (string.contains(Themes.URI_DRAWABLE)) {
			String drawableResourceName = string.substring(Themes.URI_DRAWABLE.length());
			int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
			Bitmap bitmap = Utils.scaleDown(drawableResourceId, size, size);
			return Utils.crop(bitmap, size, size);
		}
		return null;
	}

	public boolean isPair(int id1, int id2) {
		Integer integer = pairs.get(id1);
		if (integer == null) {

			return false;
		}
		return integer.equals(id2);
	}

}
