package com.skiteldev.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Connection_to_DB.connect();
        
        username = findViewById(R.id.login);
        password = findViewById(R.id.pass);
    }

    public void check(View view) {
        String log = username.getText().toString(), pass = password.getText().toString();
        if (ValidateUtil.validate(log, pass) && UserDAO.findUser(log, pass)) {
            Toast.makeText(getApplicationContext(),"congr", Toast.LENGTH_SHORT).show();



        } else {
            Toast.makeText(getApplicationContext(),"Something went wrong", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Connection_to_DB.close_DB();
    }
}
