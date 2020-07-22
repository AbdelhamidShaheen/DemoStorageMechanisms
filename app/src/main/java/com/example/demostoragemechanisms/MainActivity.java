package com.example.demostoragemechanisms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button buttonSign;
    CheckBox State;
    SharedPreferences preferences;
    public static final String Mail = "MAIL";
    public static final String Pass = "PASS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set up Views
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);

        password = (EditText) findViewById(R.id.editTextTextPassword);
        buttonSign = (Button) findViewById(R.id.Sign);
        State = (CheckBox) findViewById(R.id.checkState);
        //set prefrences
        preferences = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        // set up Intent
        final Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        //check User Crediental
        String c_mail = preferences.getString(Mail, "null");
        String c_pass = preferences.getString(Pass, "null");
        if (c_mail != "null" && c_pass != "null") {
            intent.putExtra(Mail, c_mail);
            intent.putExtra(Pass, c_pass);
            startActivity(new Intent(intent));
            finish();


        }
        State.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Editable mail = email.getText();
                    Editable pass = password.getText();

                    if (!TextUtils.isEmpty(mail) && !TextUtils.isEmpty(pass)) {
                        editor.putString(Mail, mail.toString());
                        editor.putString(Pass, pass.toString());
                        editor.commit();

                    } else {
                        Toast.makeText(getApplicationContext(), "Fields Is Empty", Toast.LENGTH_LONG).show();
                        State.setChecked(false);
                    }
                }


            }
        });
        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getEditableText().toString();
                String pass = password.getEditableText().toString();
                Toast.makeText(getApplicationContext(), mail + "   " + pass, Toast.LENGTH_LONG).show();

                if (!TextUtils.isEmpty(mail) && !TextUtils.isEmpty(pass)) {
                    intent.putExtra(Mail, mail);
                    intent.putExtra(Pass, pass);
                    startActivity(intent);
                    finish();


                } else {
                    Toast.makeText(getApplicationContext(), "Fields Is Empty", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}