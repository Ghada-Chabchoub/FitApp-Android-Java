package com.example.myprojects1;


import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

public class DatabaseHandler {
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public DatabaseHandler(Context context) {
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("FitAppManager"); // Reference to your Realtime Database
    }

    void addOrUpdateInformation(InformationDB information) {
        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference userReference = mDatabase.child("informations").child(userId);

        // Check if the user has already submitted information
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // User already has information, update it
                    updateInformation(userReference, information);
                } else {
                    // User does not have information, add it
                    addInformation(userReference, information);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }


    private void addInformation(DatabaseReference userReference, InformationDB information) {
        String infoId = userReference.push().getKey();
        userReference.child(infoId).setValue(information);
    }

    private void updateInformation(DatabaseReference userReference, InformationDB information) {
        userReference.setValue(information);
    }

    InformationDB getInformation() {
        DatabaseReference infoReference = mDatabase.child("informations")
                .child(mAuth.getCurrentUser().getUid());

        infoReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    InformationDB information = dataSnapshot.getValue(InformationDB.class);

                } else {

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return null;
    }

    /******************** Activity table *******************************/
    void addActivites(ActiviteDB activite) {
        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference userReference = mDatabase.child("activites").child(userId);
        String activityId = userReference.push().getKey();
        userReference.child(activityId).setValue(activite);
    }

    ActiviteDB getActivite(String activityId) {
        DatabaseReference activityReference = mDatabase.child("activites")
                .child(mAuth.getCurrentUser().getUid()).child(activityId);

        activityReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ActiviteDB activite = dataSnapshot.getValue(ActiviteDB.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return null;
    }
    void getActivitesForCurrentUser(ValueEventListener listener) {
        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference userReference = mDatabase.child("activites").child(userId);
        userReference.addListenerForSingleValueEvent(listener);
    }




  /*  public static double calculateCalories(InformationDB information, ActiviteDB activite) {
        double caloriesBurned=0;
        try {
        if (veloSum > 0) {
            // Calories burned for biking
            return caloriesBurned=23 * veloSum;
        } else if (courseSum> 0 || marcheSum > 0) {
            // Calories burned for running or walking
            return caloriesBurned=information.getPoid() * (courseSum + marcheSum);
        } else if (autreSum> 0) {
            // Calories burned for other activities
            return caloriesBurned=(8 * 3.5 * information.getPoid() / 200);
        }
        } catch (Exception e) {
            Log.e("Error", "Error calculating calories: " + e.getMessage());
        }
        return 0; // Or handle the error case appropriately
    }
       // return caloriesBurned; */






}//fin prog