package com.example.myprojects1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity implements View.OnClickListener {
   Button btntips,btnprog,btnactvites,btninf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btnactvites=findViewById(R.id.activitesbtn);
        btnactvites.setOnClickListener(this);
        btninf=findViewById(R.id.infobtn);
        btninf.setOnClickListener(this);
        btntips=findViewById(R.id.tipsbtn);
        btntips.setOnClickListener(this);
        btnprog=findViewById(R.id.progressbtn);
        btnprog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.infobtn){
            Intent i = new Intent(welcome.this, InfoPage.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.progressbtn) {
            Intent i = new Intent(welcome.this, ProgressPage.class);
            startActivity(i);


        }

        else if (v.getId()==R.id.activitesbtn) {
            Intent i = new Intent(welcome.this, ActivPhyPage.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.tipsbtn) {
            Intent i = new Intent(welcome.this, TipsPage.class);
            startActivity(i);
            }




        }

    }//fin onclick
