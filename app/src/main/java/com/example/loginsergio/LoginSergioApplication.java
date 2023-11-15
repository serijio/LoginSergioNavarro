package com.example.loginsergio;

import android.app.Application;

import com.google.android.material.color.DynamicColors;
import com.google.android.material.color.utilities.DynamicColor;

public class LoginSergioApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}