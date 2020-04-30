package com.memo.match.model;

import com.memo.match.themes.Theme;


public class Game {

	/**
	 * กำหนดค่าบอร์ด
	 */
	public BoardConfiguration boardConfiguration;

	/**
	 * การจัดบอร์ด
	 */
	public BoardArrangment boardArrangment;

	/**
	 * เลือกทีม
	 */
	public Theme theme;

	public GameState gameState;

}
