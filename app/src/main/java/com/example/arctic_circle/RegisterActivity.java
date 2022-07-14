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
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText etRegEmail;
    EditText etRegPass;
    EditText surName;
    EditText birthday;
    EditText phoneNumber;
    EditText etRegPass2;
    Button btnRegister;
    CheckBox confirmRules;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegEmail = findViewById(R.id.mail_registrate);
        etRegPass = findViewById(R.id.password_registrate);
        etRegPass2 = findViewById(R.id.confirm_password);
        surName = findViewById(R.id.fio);
        birthday = findViewById(R.id.date);
        phoneNumber = findViewById(R.id.phone);
        btnRegister = findViewById(R.id.registrate_registrate);
        confirmRules = findViewById(R.id.confirm_rules);

        btnRegister.setEnabled(false);
        confirmRules.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    btnRegister.setEnabled(true);
                else
                    btnRegister.setEnabled(false);
            }
        });
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(view -> {
            createUser();
        });
    }

    private void createUser(){
        String email = etRegEmail.getText().toString();
        String password = etRegPass.getText().toString();
        String name = surName.getText().toString();
        String passConfirm = etRegPass2.getText().toString();

        if (TextUtils.isEmpty(name)){
            surName.setError("ФИО не может быть пустым");
            surName.requestFocus();
        } else if (TextUtils.isEmpty(email)){
            etRegEmail.setError("Электронная почта не может быть пустой");
            etRegEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etRegPass.setError("Пароль не может быть пустым");
            etRegPass.requestFocus();
        }else if (TextUtils.isEmpty(passConfirm)){
            etRegPass2.setError("Потвердите пароль");
            etRegPass2.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Пользователь успешно зарегистрирован", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }else{
                        Toast.makeText(RegisterActivity.this, "Ошибка регистрации: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}