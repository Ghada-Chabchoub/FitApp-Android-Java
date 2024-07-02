/*package com.example.myprojects1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Create extends AppCompatActivity {
    Button btnCre2;
    ImageButton btnexitCre;
    EditText email, password;
    String TAG = "Android Test";
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.emailCreate);
        password = findViewById(R.id.passwordCreate);

        btnCre2 = findViewById(R.id.btnCreate);
        btnexitCre = findViewById(R.id.exitCreate);
        btnexitCre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                Intent i = new Intent(Create.this, MainActivity.class);
                startActivity(i);
            }

        }); // fin onclicklistenerExit

        btnCre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v5) {
            //if(v5.getId()==R.id.btnCreate){
                signUp();

            }
            //}
        });//finonclickCreate


    }// fin oncreate


    public void signUp(){
        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(Create.this, "you create a new account",
                                    Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Create.this, Login.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Create.this, "creation failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }









}//Fin
*/
package com.example.myprojects1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class Create extends AppCompatActivity {
    Button btnCre2;
    ImageButton btnexitCre;
    EditText email, password;
    String TAG = "Android Test";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.emailCreate);
        password = findViewById(R.id.passwordCreate);

        btnCre2 = findViewById(R.id.btnCreate);
        btnexitCre = findViewById(R.id.exitCreate);

        btnexitCre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                Intent i = new Intent(Create.this, MainActivity.class);
                startActivity(i);
            }
        }); // fin onclicklistenerExit

        btnCre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v5) {
                // Vérifier que les champs ne sont pas vides
                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(Create.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                } else {
                    signUp();
                }
            }
        }); // fin onclickCreate
    } // fin onCreate

    public void signUp() {
        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(Create.this, "You created a new account", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Create.this, Login.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.e(TAG, "createUserWithEmail:failure", task.getException());
                            Exception exception = task.getException();
                            if (exception instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(Create.this, "Email address is already in use by another account.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Create.this, "Creation failed: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
}




