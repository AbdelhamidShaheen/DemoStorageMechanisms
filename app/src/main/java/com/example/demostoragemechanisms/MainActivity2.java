package com.example.demostoragemechanisms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView mail;
    TextView pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mail = (TextView) findViewById(R.id.mail);
        pass = (TextView) findViewById(R.id.pass);

        Intent intent = getIntent();
        String m = intent.getStringExtra(MainActivity.Mail);
        String p = intent.getStringExtra(MainActivity.Pass);

        mail.setText(m);
        pass.setText(p);

    }
}