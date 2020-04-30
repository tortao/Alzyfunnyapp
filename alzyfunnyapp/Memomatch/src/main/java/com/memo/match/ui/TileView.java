package com.memo.match.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.memo.match.R;

public class TileView extends FrameLayout {

	private RelativeLayout mTopImage;
	private ImageView mTileImage;
	private boolean mFlippedDown = true;

	public TileView(Context context) {
		this(context, null);
	}

	public TileView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public static TileView fromXml(Context context, ViewGroup parent) {
		return (TileView) LayoutInflater.from(context).inflate(R.layout.tile_view, parent, false);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		mTopImage = (RelativeLayout) findViewById(R.id.image_top);
		mTileImage = (ImageView) findViewById(R.id.image);
	}

	public void setTileImage(Bitmap bitmap) {
		mTileImage.setImageBitmap(bitmap);
	}

	public void flipUp() {
		mFlippedDown = false;
		flip();
	}

	public void flipDown() {
		mFlippedDown = true;
		flip();
	}
	
	private void flip() {
		FlipAnimation flipAnimation = new FlipAnimation(mTopImage, mTileImage);
		if (mTopImage.getVisibility() == View.GONE) {
			flipAnimation.reverse();
		}
		startAnimation(flipAnimation);
	}

	public boolean isFlippedDown() {
		return mFlippedDown;
	}

	public class FlipAnimation extends Animation {
		private Camera camera;

		private View fromView;
		private View toView;

		private float centerX;
		private float centerY;

		private boolean forward = true;



		public FlipAnimation(View fromView, View toView) {
			this.fromView = fromView;
			this.toView = toView;

			setDuration(700);
			setFillAfter(false);
			setInterpolator(new AccelerateDecelerateInterpolator());
		}

		public void reverse() {
			forward = false;
			View switchView = toView;
			toView = fromView;
			fromView = switchView;
		}

		@Override
		public void initialize(int width, int height, int parentWidth, int parentHeight) {
			super.initialize(width, height, parentWidth, parentHeight);
			centerX = width / 2;
			centerY = height / 2;
			camera = new Camera();
		}

		@Override
		protected void applyTransformation(float interpolatedTime, Transformation t) {

			final double radians = Math.PI * interpolatedTime;
			float degrees = (float) (180.0 * radians / Math.PI);

			//
			// หมุนแผ่นกลับแบบมีมิติ
			//
			//
			if (interpolatedTime >= 0.5f) {
				degrees -= 180.f;
				fromView.setVisibility(View.GONE);
				toView.setVisibility(View.VISIBLE);
			}

			if (forward)
				degrees = -degrees;


			final Matrix matrix = t.getMatrix();
			camera.save();
			camera.rotateY(degrees);
			camera.getMatrix(matrix);
			camera.restore();
			matrix.preTranslate(-centerX, -centerY);
			matrix.postTranslate(centerX, centerY);
		}
	}
}
