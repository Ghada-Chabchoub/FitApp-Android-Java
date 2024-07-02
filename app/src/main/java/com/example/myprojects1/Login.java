package com.example.myprojects1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity  {
    Button btnLog2;
    ImageButton btnexitLog;
    EditText email, password;
    String TAG = "Android Test";
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth =FirebaseAuth.getInstance();

        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        btnLog2 = findViewById(R.id.btnLogin);
        btnexitLog = findViewById(R.id.exitbtn);
        btnexitLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
            }

        }); // fin onclicklistenerExit


        btnLog2.setOnClickListener(new View.OnClickListener() {
            @Override

        public void onClick(View v) {
            if(v.getId()==R.id.btnLogin){
                login();
            }
        }

        });//fin btn login
    }//fin onCreate

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Log.d(TAG, "already logged in");
            Toast.makeText(Login.this, "already logged in",
                    Toast.LENGTH_SHORT).show();
            Intent i2 = new Intent(Login.this, welcome.class);
            startActivity(i2);
             }

    }//onstart
    public void login(){
        mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Toast.makeText(Login.this, "success",
                                    Toast.LENGTH_SHORT).show();
                            Intent i2 = new Intent(Login.this, welcome.class);
                            startActivity(i2);





                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }



    // menu
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.update){

        } else if (item.getItemId()==R.id.logout) {

        }
        else if (item.getItemId()==R.id.setting){

        }


        return super.onOptionsItemSelected(item);
    } */
}//Fin