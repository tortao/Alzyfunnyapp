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


public interface EventObserver {

	void onEvent(FlipCardEvent event);

	void onEvent(DifficultySelectedEvent event);

	void onEvent(HidePairCardsEvent event);

	void onEvent(FlipDownCardsEvent event);

	void onEvent(StartEvent event);

	void onEvent(ThemeSelectedEvent event);

	void onEvent(GameWonEvent event);

	void onEvent(BackGameEvent event);

	void onEvent(NextGameEvent event);

	void onEvent(ResetBackgroundEvent event);

}
