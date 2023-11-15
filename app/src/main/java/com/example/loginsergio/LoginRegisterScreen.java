package com.example.loginsergio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class LoginRegisterScreen extends AppCompatActivity {

    ImageView logoRegister;
    TextView appNameRegister;
    TextInputLayout emailRegister;
    TextInputLayout userRegister;
    MaterialButton createAcc;
    MaterialButton backLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register_screen);

        ImageView backgroundLogin = findViewById(R.id.backgroundRegister);

        Glide.with(this)
                .load("https://pbs.twimg.com/media/FflNrOHWAAMxuHR.jpg:large")
                .into(backgroundLogin);

        logoRegister = findViewById(R.id.logoRegister);
        appNameRegister = findViewById(R.id.appNameRegister);
        emailRegister = findViewById(R.id.emailRegister);
        userRegister = findViewById(R.id.userRegister);
        createAcc = findViewById(R.id.registerNowButton);
        backLogin = findViewById(R.id.backToLogin);

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionBack();
            }
        });
    }


    public void onBackPressed() {
        transitionBack();
    }

    public void transitionBack(){
        Intent intent = new Intent(LoginRegisterScreen.this, LoginMainScreen.class);

        Pair[] pairs = new Pair[6];
        pairs[0] = new Pair<View, String>(logoRegister, "ryodanTrans2");
        pairs[1] = new Pair<View, String>(appNameRegister, "crTrans2");
        pairs[2] = new Pair<View, String>(emailRegister, "emailTrans");
        pairs[3] = new Pair<View, String>(userRegister, "userTrans");
        pairs[4] = new Pair<View, String>(createAcc, "accTrans");
        pairs[5] = new Pair<View, String>(backLogin, "loginTrans");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginRegisterScreen.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
            finish();
        }
    }
}