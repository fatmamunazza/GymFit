package com.example.gymfit.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymfit.R;
import com.example.gymfit.common;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

import static com.example.gymfit.R.string.course_para1;
import static com.example.gymfit.R.string.course_time1;
import static com.example.gymfit.R.string.course_title1;
import static com.example.gymfit.common.apiKey;


public class course_register extends Fragment {


    public course_register() {
        // Required empty public constructor
    }

    Spinner state,city;
    TextView headingTitle,registerTitle,registerTime,registerPara,tvName,tvPhone,tvEmail,tvAddress;
    EditText name,phone,email,address,submit;
    ImageView registerImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_course_register, container, false);


        final String viewName = getArguments().getString("viewName");

        headingTitle=view.findViewById(R.id.heading_title);
        registerImage=view.findViewById(R.id.registerImage);
        registerTitle=view.findViewById(R.id.register_title);
        registerTime=view.findViewById(R.id.register_time);
        registerPara=view.findViewById(R.id.register_para);

        tvName=view.findViewById(R.id.tvName);
        tvPhone=view.findViewById(R.id.tvPhone);
        tvEmail=view.findViewById(R.id.tvEmail);
        tvAddress=view.findViewById(R.id.tvAddress);

        name=view.findViewById(R.id.name);
        phone=view.findViewById(R.id.phone);
        email=view.findViewById(R.id.email);
        address=view.findViewById(R.id.address);

        submit=view.findViewById(R.id.submit);

        headingTitle.setText(viewName);

        switch (viewName){
            case "KETTLEBELL":
                registerImage.setImageResource(R.drawable.register1);
                registerTitle.setText(course_title1);
                registerTime.setText(course_time1);
                registerPara.setText(course_para1);
                break;
            case "CONJUGATE METHODS":
                registerImage.setImageResource(R.drawable.register2);
                registerTitle.setText(R.string.course_title2);
                registerTime.setText(R.string.course_time2);
                registerPara.setText(R.string.course_para2);
                break;
            case "ADVANCED GYMNASTIC":
                registerImage.setImageResource(R.drawable.register3);
                registerTitle.setText(R.string.course_title3);
                registerTime.setText(R.string.course_time3);
                registerPara.setText(R.string.course_para3);
                break;
            case "BODY PUMP":
                registerImage.setImageResource(R.drawable.register4);
                registerTitle.setText(R.string.course_title4);
                registerTime.setText(R.string.course_time4);
                registerPara.setText(R.string.course_para4);
                break;
            case "STRIKING":
                registerImage.setImageResource(R.drawable.register5);
                registerTitle.setText(R.string.course_title5);
                registerTime.setText(R.string.course_time5);
                registerPara.setText(R.string.course_para5);
                break;
            case "CARDIO":
                registerImage.setImageResource(R.drawable.register6);
                registerTitle.setText(R.string.course_title6);
                registerTime.setText(R.string.course_time6);
                registerPara.setText(R.string.course_para6);
                break;
            default:
                break;
        }


        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvName.setVisibility(View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvPhone.setVisibility(View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvEmail.setVisibility(View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvAddress.setVisibility(View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean nameB=name.getText().toString().trim().isEmpty();
                Boolean phoneB=phone.getText().toString().trim().isEmpty();
                Boolean emailB=email.getText().toString().trim().isEmpty();
                Boolean addressB=address.getText().toString().trim().isEmpty();


                if(!nameB && !phoneB && !emailB && !addressB){
                    Toast.makeText(getActivity(), "You have successfully register for " + viewName, Toast.LENGTH_SHORT).show();
                }
                else{

                }
            }
        });












       /* state=view.findViewById(R.id.state);
        city=view.findViewById(R.id.city);*/
/*
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(),R.array.state_array,R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        state.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(getContext(),R.array.state_array,R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        state.setAdapter(adapter1);*/


        return view;
    }
}
