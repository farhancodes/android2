package com.example.farhan_rehan.loginapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by Farhan_Rehan on 9/24/2016.
 */
public class SplashScreen extends Activity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sessionManager = new SessionManager();
        final String status = sessionManager.getPreferences(SplashScreen.this, "status");
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    if (status.equals("1")) {
                        Intent intent = new Intent(SplashScreen.this, WelcomeScreen.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        thread.start();
    }
}
