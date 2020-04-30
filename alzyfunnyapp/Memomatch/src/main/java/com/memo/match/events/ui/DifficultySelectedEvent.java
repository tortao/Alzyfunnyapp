package com.memo.match.events.ui;

import com.memo.match.events.AbstractEvent;
import com.memo.match.events.EventObserver;

/**
 * เมื่อกดกลับสู่เมนู
 */
public class DifficultySelectedEvent extends AbstractEvent {

	public static final String TYPE = DifficultySelectedEvent.class.getName();

	public final int difficulty;
	
	public DifficultySelectedEvent(int difficulty) {
		this.difficulty = difficulty;
	}
	
	@Override
	protected void fire(EventObserver eventObserver) {
		eventObserver.onEvent(this);
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
