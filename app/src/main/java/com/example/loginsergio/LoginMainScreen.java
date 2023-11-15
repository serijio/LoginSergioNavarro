package com.example.loginsergio;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginMainScreen extends AppCompatActivity{
    String text = "";
    ImageView logoLogin;
    TextView appNameLogin;
    TextInputLayout username;
    TextInputLayout pass;
    MaterialButton loginNow;
    MaterialButton register;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main_screen);

        ImageView backgroundLogin = findViewById(R.id.backgroundLogin);

        Glide.with(this)
                .load("https://pbs.twimg.com/media/FflNrOHWAAMxuHR.jpg:large")
                .into(backgroundLogin);

        logoLogin = findViewById(R.id.logoLogin);
        appNameLogin = findViewById(R.id.appNameLogin);
        username = findViewById(R.id.userLogin);
        pass = findViewById(R.id.passLogin);
        loginNow = findViewById(R.id.loginButton);
        register = findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginMainScreen.this, LoginRegisterScreen.class);

                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View, String>(logoLogin, "ryodanTrans");
                pairs[1] = new Pair<View, String>(appNameLogin, "crTrans2");
                pairs[2] = new Pair<View, String>(username, "usernameTrans");
                pairs[3] = new Pair<View, String>(pass, "passTrans");
                pairs[4] = new Pair<View, String>(loginNow, "loginNowTrans");
                pairs[5] = new Pair<View, String>(register, "registerTrans");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginMainScreen.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        });

        MaterialButton forgotpass = findViewById(R.id.noPassButton);
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = LayoutInflater.from(LoginMainScreen.this).inflate(R.layout.alert_dialog, null);
                MaterialAlertDialogBuilder pass_dialog = new MaterialAlertDialogBuilder(LoginMainScreen.this)
                        .setTitle("Have you forgotten your password?")
                        .setMessage("If you already have an account, please type your email:")
                        .setView(view1)
                        .setPositiveButton("Thx :)", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int x) {
                                Toast.makeText(LoginMainScreen.this, "We have sent a password restore email", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int x) {
                                //Toast.makeText(LoginMainScreen.this, "You have been returned to the login page", Toast.LENGTH_SHORT).show();
                            }
                        });

                pass_dialog.create();
                pass_dialog.show();

            }
        });
    }
}