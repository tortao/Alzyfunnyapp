package com.memo.match.events.ui;

import com.memo.match.events.AbstractEvent;
import com.memo.match.events.EventObserver;

/**
 * เมื่อกดกลับสู่เมนู
 */
public class ResetBackgroundEvent extends AbstractEvent {

	public static final String TYPE = ResetBackgroundEvent.class.getName();

	@Override
	protected void fire(EventObserver eventObserver) {
		eventObserver.onEvent(this);
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
