package com.memo.match.events.engine;

import com.memo.match.events.AbstractEvent;
import com.memo.match.events.EventObserver;
import com.memo.match.model.GameState;

/**
 * เมื่อกดกลับสู่เมนู
 */
public class GameWonEvent extends AbstractEvent {

	public static final String TYPE = GameWonEvent.class.getName();

	public GameState gameState;

	
	public GameWonEvent(GameState gameState) {
		this.gameState = gameState;
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
