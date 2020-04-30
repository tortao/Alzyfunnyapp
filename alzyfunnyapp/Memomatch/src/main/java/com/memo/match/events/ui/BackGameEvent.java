package com.memo.match.events.ui;

import com.memo.match.events.AbstractEvent;
import com.memo.match.events.EventObserver;

/**
 * เมื่อกดกลับสู่เมนู
 */
public class BackGameEvent extends AbstractEvent {

	public static final String TYPE = BackGameEvent.class.getName();

	@Override
	protected void fire(EventObserver eventObserver) {
		eventObserver.onEvent(this);
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
