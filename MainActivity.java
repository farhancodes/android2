package com.example.farhan_rehan.loginapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView hint, forgot_pass, register;
    EditText email_id, email_id2, password;
    Button login, goWithouLogin;
    String email, email2, pass;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager=new SessionManager();
        hint = (TextView) findViewById(R.id.setMessage);
        forgot_pass = (TextView) findViewById(R.id.forgot_pass);
        register = (TextView) findViewById(R.id.register);
        email_id = (EditText) findViewById(R.id.email_id);
        email_id2 = (EditText) findViewById(R.id.email_id2);
        password = (EditText) findViewById(R.id.password);
        email_id.setTypeface(Typeface.MONOSPACE);
        login = (Button) findViewById(R.id.login);
        goWithouLogin = (Button) findViewById(R.id.login2);
        forgot_pass.setOnClickListener(this);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
        goWithouLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgot_pass:
                Toast.makeText(MainActivity.this, "Work in progress", Toast.LENGTH_SHORT).show();
                break;

            case R.id.register:
                Toast.makeText(MainActivity.this, "Work in progress", Toast.LENGTH_SHORT).show();
                break;

            case R.id.login:
                email = email_id.getText().toString().trim();
                email2 = email_id2.getText().toString().trim();
                pass = password.getText().toString().trim();
                String emailPattern_co_in = "[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789._-]+@[abcdefghijklmnopqrstuvwxyz]+\\.+[abcdefghijklmnopqrstuvwxyz]+\\.+[abcdefghijklmnopqrstuvwxyz]+";
                String emailPattern_com = "[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789._-]+@[abcdefghijklmnopqrstuvwxyz]+\\.+[abcdefghijklmnopqrstuvwxyz]+";
                String passMatch = "[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789]+";
                if (email.matches(emailPattern_co_in) || email.matches(emailPattern_com)) {
                    if (pass.matches(passMatch)) {
                        sessionManager.setPreferences(MainActivity.this, "status", "1");
                        Intent intent=new Intent(MainActivity.this, WelcomeScreen.class);
                        startActivity(intent);
                        finish();
                    } else {
                        hint.setText("Please enter correct password in alphabatic and numeric combination");
                        hint.setTextColor(Color.RED);
                    }
                } else {
                    hint.setText("Please enter valid email id");
                    hint.setTextColor(Color.RED);
                }

                break;

            case R.id.login2:
                Toast.makeText(MainActivity.this, "Work in progress", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
