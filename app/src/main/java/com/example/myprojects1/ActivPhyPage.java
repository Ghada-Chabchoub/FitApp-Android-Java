package com.example.myprojects1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivPhyPage extends AppCompatActivity implements View.OnClickListener{
    EditText tcourse, tmarche, tvelo, tautre;
    Button btn;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activ_phy_page);

        tcourse=findViewById(R.id.course);
        tmarche=findViewById(R.id.marchr);
        tvelo=findViewById(R.id.velo);
        tautre=findViewById(R.id.autre);
        btn = findViewById(R.id.btnSubmitAct);
        btn.setOnClickListener(this);



        db = new DatabaseHandler(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmitAct) {
            try {

                float course = Float.parseFloat(tcourse.getText().toString());
                float marche = Float.parseFloat(tmarche.getText().toString());
                float velo = Float.parseFloat(tvelo.getText().toString());
                float autre = Float.parseFloat(tautre.getText().toString());

                ActiviteDB activite = new ActiviteDB(marche,course,velo,autre);
                db.addActivites(activite);
                Toast.makeText(getApplicationContext(), "Informations enregistrées avec succès", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ActivPhyPage.this, ProgressPage.class);
                intent.putExtra("activite",activite);
                startActivity(intent);

            }
            catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Erreur de conversion des données", Toast.LENGTH_SHORT).show();

            }
        }

    }
}