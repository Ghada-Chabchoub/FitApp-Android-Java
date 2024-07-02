package com.example.myprojects1;





import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**************************************************************************************************************/
/*public class ProgressPage extends AppCompatActivity {

    TextView tcaloriesTextView;

    DatabaseHandler db;
    // Assuming myRef is obtained like this
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("informations");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_page);
        tcaloriesTextView = findViewById(R.id.caloriesTextView);
        db = new DatabaseHandler(this);
        /////////////////////
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        InformationDB information = getIntent().getParcelableExtra("information");
        ActiviteDB activite = getIntent().getParcelableExtra("activite");
      Log.d("Debug", "Information: " + information);
      Log.d("Debug", "Activite: " + activite);

      if(information !=null  && activite !=null){
        double caloriesBurned = db.calculateCalories (information, activite);
        tcaloriesTextView.setText("CaloriesBurned " + caloriesBurned);
        ActiviteDB act = new ActiviteDB(caloriesBurned);
        act.setCaloriesBurned(caloriesBurned);
        db.addActivites(act);
       }
       else {
           Toast.makeText(getApplicationContext(), "pas de progress", Toast.LENGTH_SHORT).show();

       }
    }

    }



 ***********************************


public class ProgressPage extends AppCompatActivity {

    private static final String TAG = "ProgressPage";
    TextView tcaloriesTextView;
    DatabaseHandler db;
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("activites");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_page);
        tcaloriesTextView = findViewById(R.id.caloriesTextView);
        db = new DatabaseHandler(this);

        ValueEventListener activitesListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d(TAG, "DataSnapshot: " + dataSnapshot.toString());
                Toast.makeText(getApplicationContext(), "Information mmmm", Toast.LENGTH_SHORT).show();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.d(TAG, "Snapshot Child: " + snapshot.toString());
                    Toast.makeText(getApplicationContext(), "Information ppppppppp", Toast.LENGTH_SHORT).show();

                    // Iterate over the children to get each activite
                    ActiviteDB activite = snapshot.getValue(ActiviteDB.class);

                    if (activite != null) {
                        Log.d(TAG, "Activite: " + activite);
                        Toast.makeText(getApplicationContext(), "Information iiiiiii", Toast.LENGTH_SHORT).show();

                        // Retrieve information from the Intent
                        InformationDB information = getIntent().getParcelableExtra("information");

                        if (information != null) {
                            double caloriesBurned = db.calculateCalories(information, activite);
                            tcaloriesTextView.setText("CaloriesBurned " + caloriesBurned);

                            ActiviteDB act = new ActiviteDB(caloriesBurned);
                            act.setCaloriesBurned(caloriesBurned);

                            // Assuming addActivites method adds to the database
                            db.addActivites(act);
                        } else {
                            Toast.makeText(getApplicationContext(), "Information is null", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        };

        myRef.addValueEventListener(activitesListener);
    }

    // Rest of your code...





    public static double calculateCalories(InformationDB information, ActiviteDB activite) {
        double caloriesBurned = 0;
        try {
            if (activite.getVelo() > 0) {
                // Calories burned for biking
                caloriesBurned = 23 * activite.getVelo();
            } else if (activite.getCourse() > 0 || activite.getMarche() > 0) {
                // Calories burned for running or walking
                caloriesBurned = information.getPoid() * (activite.getCourse() + activite.getMarche());
            } else if (activite.getAutre() > 0) {
                // Calories burned for other activities
                caloriesBurned = (8 * 3.5 * information.getPoid() / 200);
            }
        } catch (Exception e) {
            Log.e("Error", "Error calculating calories: " + e.getMessage());
        }
        return caloriesBurned;
    }
}*/



import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProgressPage extends AppCompatActivity {

    private TextView marcheTextView, courseTextView, veloTextView, autreTextView;
    String activityId;
    DatabaseHandler db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_page);

        marcheTextView = findViewById(R.id.marcheTextView);
        courseTextView = findViewById(R.id.courseTextView);
        veloTextView = findViewById(R.id.veloTextView);
        autreTextView = findViewById(R.id.autreTextView);
        db = new DatabaseHandler(this);
        displayActivitySum();
    }

    private void displayActivitySum() {
        db.getActivitesForCurrentUser(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                double marcheSum = 0;
                double courseSum = 0;
                double veloSum = 0;
                double autreSum = 0;

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ActiviteDB activite = snapshot.getValue(ActiviteDB.class);
                    if (activite != null) {
                        marcheSum += activite.getMarche();
                        courseSum += activite.getCourse();
                        veloSum += activite.getVelo();
                        autreSum += activite.getAutre();
                    }
                }

                // Display the sums in the TextViews
                marcheTextView.setText("vous avez atteind la valeur de " + String.valueOf(marcheSum) + "m de marche");
                courseTextView.setText("vous avez atteind la valeur de " +String.valueOf(courseSum) + " m de course");
                veloTextView.setText("vous avez atteind la valeur de " +String.valueOf(veloSum) + "m de velo");
                autreTextView.setText("vous avez atteind " +String.valueOf(autreSum) + "h d'une activité intense");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public static double calculateCalories(float marche, float course, float velo, float autre, float poid) {
        double caloriesBurned = 0;

        if (velo > 0) {

            caloriesBurned = 23 * velo;
        } else if (course > 0 || marche > 0) {
            caloriesBurned = poid * (course + marche);
        } else if (autre > 0) {
            caloriesBurned = 8 * 3.5 * poid / 200;
        }

        return caloriesBurned;
    }
}//fin prog