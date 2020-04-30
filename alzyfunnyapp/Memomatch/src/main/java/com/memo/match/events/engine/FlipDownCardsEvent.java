package com.memo.match.events.engine;

import com.memo.match.events.AbstractEvent;
import com.memo.match.events.EventObserver;

/**
 * เมื่อกดกลับสู่เมนู
 */
public class FlipDownCardsEvent extends AbstractEvent {

	public static final String TYPE = FlipDownCardsEvent.class.getName();

	public FlipDownCardsEvent() {
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
