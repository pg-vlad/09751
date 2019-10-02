package com.skiteldev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.login);
        password = findViewById(R.id.pass);
    }

    public void check(View view) {
        String log = username.getText().toString(), pass = password.getText().toString();
        if (ValidateUtil.validate(log, pass)) {
            Toast.makeText(getApplicationContext(),"congr", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"wrong input", Toast.LENGTH_SHORT).show();
        }
    }


}
