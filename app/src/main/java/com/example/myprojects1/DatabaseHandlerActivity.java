package com.example.myprojects1;



import android.content.Context;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseHandlerActivity {
    /*private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;


   public DatabaseHandlerActivity(Context context) {
        mDatabase = FirebaseDatabase.getInstance().getReference("FitAppManager"); // Reference to your Realtime Database
        mAuth = FirebaseAuth.getInstance();
    }

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
    } */


   }





