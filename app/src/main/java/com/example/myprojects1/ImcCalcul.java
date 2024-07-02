package com.example.myprojects1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ImcCalcul extends AppCompatActivity {
    private TextView imcTextView;
    private TextView classificationTextView;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_calcul);
        imcTextView = findViewById(R.id.imcTextView);
        classificationTextView = findViewById(R.id.classification);
        db = new DatabaseHandler(this);

        InformationDB information = getIntent().getParcelableExtra("information");

        if (information != null) {
            double imc = calculateImc(information.getPoid(), (int) information.getTaille());
            imcTextView.setText("IMC: " + imc);
            String classification = determineClassification(imc);
            classificationTextView.setText("Classification: " + classification);
            InformationDB info = new InformationDB(imc);
            information.setImc(imc);
            db.addOrUpdateInformation(information);

        }
        else {
            Toast.makeText(getApplicationContext(), "Veuiller remplire les champs", Toast.LENGTH_SHORT).show();
        }
    }

    private double calculateImc(float poid, int taille) {
       return poid / ((double) taille / 100 * taille / 100);
    }

    private String determineClassification(double imc) {

        if (imc < 18.5) {
            return "Underweight";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Normal weight";
        } else if (imc >= 25 && imc < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}