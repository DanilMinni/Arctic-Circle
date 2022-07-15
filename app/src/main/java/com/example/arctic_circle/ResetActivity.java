package com.example.arctic_circle;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetActivity extends AppCompatActivity {

    EditText emailReset;
    TextView register;
    Button btnReset;
    FirebaseAuth auth = FirebaseAuth.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        register = findViewById(R.id.reg);
        btnReset = findViewById(R.id.btnReset);
        emailReset = findViewById(R.id.EmailReset);

        auth.setLanguageCode("ru");

        btnReset.setOnClickListener(view -> {
            String email = emailReset.getText().toString();

            auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "Email sent.");
                                startActivity(new Intent(ResetActivity.this, LoginActivity.class));
                            }
                        }
                    });

        });



        register.setOnClickListener(view ->{
            startActivity(new Intent(ResetActivity.this, RegisterActivity.class));
        });
    }


}