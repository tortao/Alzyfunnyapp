package com.memo.match.common;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.memo.match.R;

public class Music {

	public static boolean OFF = false;

	public static void playCorrect() {
		if (!OFF) {
			MediaPlayer mp = MediaPlayer.create(Shared.context, R.raw.correct);
			mp.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					mp.reset();
					mp.release();
					mp = null;
				}

			});
			mp.start();
		}
	}

	public static void playBackgroundMusic() {
		if (!OFF) {
			MediaPlayer mp = MediaPlayer.create(Shared.context, R.raw.background_music);
			mp.setOnCompletionListener(new OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					mp.reset();
					mp.release();
					mp = null;
				}

			});
			mp.start();
		}
	}

		public static void showStar() {
			if (!OFF) {
				MediaPlayer mp = MediaPlayer.create(Shared.context, R.raw.star);
				mp.setOnCompletionListener(new OnCompletionListener() {
					@Override
					public void onCompletion(MediaPlayer mp) {
						mp.reset();
						mp.release();
						mp = null;
					}

				});
				mp.start();
		}
	}
}
