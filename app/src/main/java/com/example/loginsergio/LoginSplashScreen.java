package com.example.loginsergio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.loginsergio.R;

public class LoginSplashScreen extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_splash_screen);

        ImageView logoSplash = findViewById(R.id.logoSplash);
        TextView appNameSplash = findViewById(R.id.appNameSplash);

        ImageView backgroundSplash = findViewById(R.id.backgroundSplash);

        mediaPlayer = MediaPlayer.create(this, R.raw.sound6);

        Glide.with(this)
                .load("https://pbs.twimg.com/media/FflNrOHWAAMxuHR.jpg:large")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                //.centerCrop()
                .into(backgroundSplash);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.go_up);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.go_down);

        final TextView name = findViewById(R.id.appNameSplash);
        final ImageView logo = findViewById(R.id.logoSplash);

        name.setAnimation(animation2);
        logo.setAnimation(animation1);

        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mediaPlayer.start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoginSplashScreen.this, LoginMainScreen.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(logo, "ryodanTrans");
                pairs[1] = new Pair<View, String>(name, "crTrans");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginSplashScreen.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        },4000);
    }

    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}