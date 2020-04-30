package com.example.alzyfunnyapp;

import android.app.Application;
import android.content.Context;

import com.example.alzyfunnyapp.Helper.LocaleHelper;

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
