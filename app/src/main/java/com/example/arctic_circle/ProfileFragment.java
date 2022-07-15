package com.example.arctic_circle;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    public int i = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment,
                container, false);
        view.findViewById(R.id.main_settings).setOnClickListener(this);
        view.findViewById(R.id.challendg).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_settings:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction();

                // добавляем фрагмент
                Main_set_fragment myFragment = new Main_set_fragment();
                if (i == 0) {
                    fragmentTransaction.add(R.id.container2, myFragment);
                    fragmentTransaction.commit();
                    i += 1;
                } else {
                    fragmentTransaction.replace(R.id.container2, myFragment);
                    fragmentTransaction.commit();
                } break;
            case R.id.challendg:
                 fragmentManager = getFragmentManager();
                 fragmentTransaction = fragmentManager
                        .beginTransaction();

                // добавляем фрагмент
                ChallendgFragment myChallendgFragment = new ChallendgFragment();
                if (i == 0) {
                    fragmentTransaction.add(R.id.container2, myChallendgFragment);
                    fragmentTransaction.commit();
                    i += 1;
                } else {
                    fragmentTransaction.replace(R.id.container2, myChallendgFragment);
                    fragmentTransaction.commit();
                } break;
        }

    }
}
