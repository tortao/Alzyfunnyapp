package com.memo.match.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.memo.match.R;
import com.memo.match.common.Memory;
import com.memo.match.common.Shared;
import com.memo.match.events.ui.ThemeSelectedEvent;
import com.memo.match.themes.Theme;
import com.memo.match.themes.Themes;

import java.util.Locale;

public class ThemeSelectFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = LayoutInflater.from(Shared.context).inflate(R.layout.theme_select_fragment, container, false);
		View animals = view.findViewById(R.id.theme_animals_container);
		View home_electronics = view.findViewById(R.id.theme_home_electronics_container);
		View abc = view.findViewById(R.id.theme_abc_container);

		final Theme themeAnimals = Themes.createAnimalsTheme();
		setStars((ImageView) animals.findViewById(R.id.theme_animals), themeAnimals, "animals");
		final Theme themeHome_Electronics = Themes.createHome_ElectronicsTheme();
		setStars((ImageView) home_electronics.findViewById(R.id.theme_home_electronics), themeHome_Electronics, "home_electronics");
		final Theme themeABC = Themes.createABCTheme();
		setStars((ImageView) abc.findViewById(R.id.theme_abc), themeABC, "abc");

		animals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeAnimals));
			}
		});

		home_electronics.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeHome_Electronics));
			}
		});

		abc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeABC));
			}
		});


		animateShow(animals);
		animateShow(home_electronics);
		animateShow(abc);

		return view;
	}

	private void animateShow(View view) {
		ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.5f, 1f);
		ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1f);
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.setDuration(300);
		animatorSet.playTogether(animatorScaleX, animatorScaleY);
		animatorSet.setInterpolator(new DecelerateInterpolator(2));
		view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		animatorSet.start();
	}

	private void setStars(ImageView imageView, Theme theme, String type) {
		int sum = 0;
		for (int difficulty = 1; difficulty <= 6; difficulty++) {
			sum += Memory.getHighStars(theme.id, difficulty);
		}
		int num = sum / 6;
		if (num != 0) {
			String drawableResourceName = String.format(Locale.US, type + "_theme_star_%d", num);
			int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
			imageView.setImageResource(drawableResourceId);
		}
	}
}
