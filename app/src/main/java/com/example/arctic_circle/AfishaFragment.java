package com.example.arctic_circle;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AfishaFragment extends Fragment implements View.OnClickListener {
    public int i =0;
    ImageView rImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.afisha_fragment,
                container, false);
        view.findViewById(R.id.all).setOnClickListener(this);
        view.findViewById(R.id.all_txt).setOnClickListener(this);
        view.findViewById(R.id.i_go).setOnClickListener(this);
        view.findViewById(R.id.i_go_txt).setOnClickListener(this);
        view.findViewById(R.id.town_m).setOnClickListener(this);
        view.findViewById(R.id.town_m_txt).setOnClickListener(this);
        return view;


    }


    @Override
    public void onClick(View v) {
        switch (v.getId())

        {

            case R.id.all:
//подгрузить элементы в list item и связать с list view
                break;
            case R.id.all_txt:
//подгрузить элементы в list item и связать с list view
                break;
            case R.id.i_go:
//подгрузить элементы в list item и связать с list view
                break;
            case R.id.i_go_txt:
//подгрузить элементы в list item и связать с list view
                break;
            case R.id.town_m:
//подгрузить элементы в list item и связать с list view
                break;
            case R.id.town_m_txt:
//подгрузить элементы в list item и связать с list view
                break;
        }
    }
}
