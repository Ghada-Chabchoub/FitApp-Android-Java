package com.example.myprojects1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCre , btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCre = findViewById(R.id.create);
        btnLog = findViewById(R.id.login2);

        btnCre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent i1 = new Intent(MainActivity.this, Create.class);
                startActivity(i1);
            }

        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent i2 = new Intent(MainActivity.this, Login.class);
                startActivity(i2);
            }

        });

    }// fin oncreate
}