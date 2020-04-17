package com.example.gymfit.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gymfit.R;

import java.util.TimerTask;

public class course extends Fragment implements View.OnClickListener {


    public course() {
        // Required empty public constructor
    }

    TextView kettlebellClick,conjugateClick,gymnasticClick,bodyClick,strikingClick,cardioClick;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_course, container, false);

        kettlebellClick=view.findViewById(R.id.kettlebellClick);
        conjugateClick=view.findViewById(R.id.conjugateClick);
        gymnasticClick=view.findViewById(R.id.gymnasticClick);
        bodyClick=view.findViewById(R.id.bodyClick);
        strikingClick=view.findViewById(R.id.strikingClick);
        cardioClick=view.findViewById(R.id.cardioClick);


       /* kettlebellClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                kettlebellClick.setTextColor(getResources().getColor(R.color.black));
                kettlebellClick.setTextSize(20);
                Fragment fr=new course_register();
                Bundle bundle = new Bundle();
                bundle.putString("viewName", String.valueOf(view));
                fr.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container_mainscreen, fr).addToBackStack(null).commit();


            }
        });*/
        kettlebellClick.setOnClickListener(this);
        conjugateClick.setOnClickListener(this);
        gymnasticClick.setOnClickListener(this);
        bodyClick.setOnClickListener(this);
        strikingClick.setOnClickListener(this);
        cardioClick.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        Fragment fr=new course_register();
        Bundle bundle = new Bundle();

        switch(view.getId()){
            case R.id.kettlebellClick:
                kettlebellClick.setTextColor(getResources().getColor(R.color.black));
                bundle.putString("viewName", String.valueOf(view.getTag()));
                break;
            case R.id.conjugateClick:
                conjugateClick.setTextColor(getResources().getColor(R.color.black));
                bundle.putString("viewName", String.valueOf(view.getTag()));
                break;
            case R.id.gymnasticClick:
                gymnasticClick.setTextColor(getResources().getColor(R.color.black));
                bundle.putString("viewName", String.valueOf(view.getTag()));
                break;
            case R.id.bodyClick:
                bodyClick.setTextColor(getResources().getColor(R.color.black));
                bundle.putString("viewName", String.valueOf(view.getTag()));

                break;
            case R.id.strikingClick:
                strikingClick.setTextColor(getResources().getColor(R.color.black));
                bundle.putString("viewName", String.valueOf(view.getTag()));

                break;
            case R.id.cardioClick:
                cardioClick.setTextColor(getResources().getColor(R.color.black));
                bundle.putString("viewName", String.valueOf(view.getTag()));
                break;
            default:
                break;

        }
        fr.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.container_mainscreen, fr).addToBackStack(null).commit();


    }
}
