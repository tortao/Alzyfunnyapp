package com.memo.match.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

@SuppressLint("HandlerLeak")
public abstract class CountDownClock {


	private long mStopTimeInFuture;


	private long mMillisInFuture;


	private final long mTotalCountdown;


	private final long mCountdownInterval;


	private long mPauseTimeRemaining;


	private boolean mRunAtStart;


	public CountDownClock(long millisOnTimer, long countDownInterval, boolean runAtStart) {
		mMillisInFuture = millisOnTimer;
		mTotalCountdown = mMillisInFuture;
		mCountdownInterval = countDownInterval;
		mRunAtStart = runAtStart;
	}


	public final void cancel() {
		mHandler.removeCallbacksAndMessages(null);
	}


	public synchronized final CountDownClock create() {
		if (mMillisInFuture <= 0) {
			onFinish();
		} else {
			mPauseTimeRemaining = mMillisInFuture;
		}

		if (mRunAtStart) {
			resume();
		}

		return this;
	}


	public void pause() {
		if (isRunning()) {
			mPauseTimeRemaining = timeLeft();
			cancel();
		}
	}


	public void resume() {
		if (isPaused()) {
			mMillisInFuture = mPauseTimeRemaining;
			mStopTimeInFuture = SystemClock.elapsedRealtime() + mMillisInFuture;
			mHandler.sendMessage(mHandler.obtainMessage(MSG));
			mPauseTimeRemaining = 0;
		}
	}


	public boolean isPaused() {
		return (mPauseTimeRemaining > 0);
	}


	public boolean isRunning() {
		return (!isPaused());
	}


	public long timeLeft() {
		long millisUntilFinished;
		if (isPaused()) {
			millisUntilFinished = mPauseTimeRemaining;
		} else {
			millisUntilFinished = mStopTimeInFuture - SystemClock.elapsedRealtime();
			if (millisUntilFinished < 0)
				millisUntilFinished = 0;
		}
		return millisUntilFinished;
	}


	public long totalCountdown() {
		return mTotalCountdown;
	}


	public long timePassed() {
		return mTotalCountdown - timeLeft();
	}


	public boolean hasBeenStarted() {
		return (mPauseTimeRemaining <= mMillisInFuture);
	}


	public abstract void onTick(long millisUntilFinished);


	public abstract void onFinish();

	private static final int MSG = 1;


	private final Handler mHandler = new Handler(Looper.getMainLooper()) {

		@Override
		public void handleMessage(Message msg) {

			synchronized (CountDownClock.this) {
				long millisLeft = timeLeft();

				if (millisLeft <= 0) {
					cancel();
					onFinish();
				} else if (millisLeft < mCountdownInterval) {

					sendMessageDelayed(obtainMessage(MSG), millisLeft);
				} else {
					long lastTickStart = SystemClock.elapsedRealtime();
					onTick(millisLeft);


					long delay = mCountdownInterval - (SystemClock.elapsedRealtime() - lastTickStart);


					while (delay < 0)
						delay += mCountdownInterval;

					sendMessageDelayed(obtainMessage(MSG), delay);
				}
			}
		}
	};
}
