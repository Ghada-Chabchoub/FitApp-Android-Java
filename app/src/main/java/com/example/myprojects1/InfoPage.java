package com.example.myprojects1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class InfoPage extends AppCompatActivity implements View.OnClickListener  {
    EditText tAge, tPoid, tTaille;
    RadioButton btnH, btnF;
    Button btn;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        tAge = findViewById(R.id.age);
        tPoid = findViewById(R.id.poid);
        tTaille = findViewById(R.id.taille);
        btnF = findViewById(R.id.femme);
        btnH = findViewById(R.id.homme);
        btn = findViewById(R.id.btnSubmit);

        btn.setOnClickListener(this);


        db = new DatabaseHandler(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {
            try {
                int age = Integer.parseInt(tAge.getText().toString());
                float poid = Float.parseFloat(tPoid.getText().toString());
                int taille = Integer.parseInt(tTaille.getText().toString());
                String genre = (btnF.isChecked()) ? "F" : "H";
                InformationDB information = new InformationDB(age, poid, taille, genre);
                db.addOrUpdateInformation(information);

               Toast.makeText(getApplicationContext(), "Informations enregistrées avec succès", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(InfoPage.this, ImcCalcul.class);
                intent.putExtra("information", information);
                startActivity(intent);
            }
            catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Erreur de conversion des données", Toast.LENGTH_SHORT).show();

            }
        }
    }



}
