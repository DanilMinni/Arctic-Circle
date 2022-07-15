package com.example.arctic_circle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public int i = 0;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    Boolean arg = true;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

    public void OnNewsClick (View v) {

        // получаем экземпляр FragmentTransaction
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        // добавляем фрагмент
        NewsFragment myFragment = new NewsFragment();
        if (i == 0) {
            fragmentTransaction.add(R.id.container, myFragment);
            fragmentTransaction.commit();
            i += 1;
        } else {
            fragmentTransaction.replace(R.id.container, myFragment);
            fragmentTransaction.commit();
        }
    }
    public void OnAfishaClick (View v) {


        // получаем экземпляр FragmentTransaction
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        // добавляем фрагмент
        AfishaFragment myFragment = new AfishaFragment();
        if (i == 0) {
            fragmentTransaction.add(R.id.container, myFragment);
            fragmentTransaction.commit();
            i += 1;
        } else {
            fragmentTransaction.replace(R.id.container, myFragment);
            fragmentTransaction.commit();
        }
    }

    public void OnProfileClick (View v) {


        // получаем экземпляр FragmentTransaction
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        // добавляем фрагмент
        ProfileFragment myFragment = new ProfileFragment();
        if (i == 0) {
            fragmentTransaction.add(R.id.container, myFragment);
            fragmentTransaction.commit();
            i += 1;
        } else {
            fragmentTransaction.replace(R.id.container, myFragment);
            fragmentTransaction.commit();
        }
    }



}
