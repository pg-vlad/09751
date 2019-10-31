package com.skiteldev.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.skiteldev.myapplication.R;
import com.skiteldev.myapplication.connection.SQLLiteConnection;
import com.skiteldev.myapplication.connection.UserDAO;
import com.skiteldev.myapplication.helper.ValidateUtil;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private SQLLiteConnection b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b = new SQLLiteConnection(this);
        b.updateDataBase();


        username = findViewById(R.id.login);
        password = findViewById(R.id.pass);
    }

    public void check(View view) {
        String log = username.getText().toString(), pass = password.getText().toString();
        UserDAO users = new UserDAO(b);
        if (ValidateUtil.validate(log, pass) && users.findUser(log, pass)) {
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(),"Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
