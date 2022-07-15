package com.example.arctic_circle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText etLogEmail;
    EditText etLogPass;
    Button btnLogin;
    TextView register;
    TextView forgotPass;
    CheckBox rememberMe;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogEmail = findViewById(R.id.Email);
        etLogPass = findViewById(R.id.Password);
        btnLogin = findViewById(R.id.btnLog);
        register = findViewById(R.id.reg);
        forgotPass = findViewById(R.id.forgot);
        rememberMe = findViewById(R.id.rememberMe);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view -> {
            loginUser();
        });

        register.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });

        forgotPass.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this, ResetActivity.class));
        });

    }


    private void loginUser() {
        String email = etLogEmail.getText().toString();
        String password = etLogPass.getText().toString();

        if (TextUtils.isEmpty(email)) {
            etLogEmail.setError("Электронная почта не может быть пустой");
            etLogEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            etLogPass.setError("Пароль не может быть пустым");
            etLogPass.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Пользователь успешно авторизовался", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Ошибка входа: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}