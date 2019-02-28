package com.magad.webview1tb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tvem,tvuser,tvphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvem = findViewById(R.id.emailget);
        tvuser = findViewById(R.id.userget);
        tvphone = findViewById(R.id.phone);

        tvem.setText(getIntent().getStringExtra("email"));
        tvuser.setText(getIntent().getStringExtra("user"));
        tvphone.setText(getIntent().getStringExtra("phone"));
    }
}
