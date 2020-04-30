package com.memo.match.events;

import com.memo.match.events.engine.FlipDownCardsEvent;
import com.memo.match.events.engine.GameWonEvent;
import com.memo.match.events.engine.HidePairCardsEvent;
import com.memo.match.events.ui.BackGameEvent;
import com.memo.match.events.ui.DifficultySelectedEvent;
import com.memo.match.events.ui.FlipCardEvent;
import com.memo.match.events.ui.NextGameEvent;
import com.memo.match.events.ui.ResetBackgroundEvent;
import com.memo.match.events.ui.StartEvent;
import com.memo.match.events.ui.ThemeSelectedEvent;


public class EventObserverAdapter implements EventObserver {

	public void onEvent(FlipCardEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(DifficultySelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(HidePairCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(FlipDownCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(StartEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(ThemeSelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(GameWonEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(BackGameEvent event) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void onEvent(NextGameEvent event) {
		throw new UnsupportedOperationException();		
	}

	@Override
	public void onEvent(ResetBackgroundEvent event) {
		throw new UnsupportedOperationException();		
	}

}
