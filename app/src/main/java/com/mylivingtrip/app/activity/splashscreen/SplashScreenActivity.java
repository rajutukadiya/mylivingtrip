package com.mylivingtrip.app.activity.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mylivingtrip.app.MainActivity;
import com.mylivingtrip.app.R;

public class SplashScreenActivity extends AppCompatActivity {



    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        setContentView(R.layout.activity_splash_screen);

        initialization();

        listener();
    }
    private void initialization()
    {
        loadSplash();
    }
    private void listener()
    {

    }

    private void loadSplash()
    {
        new Handler().postDelayed(new Runnable() {



            @Override
            public void run() {

                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
