package com.example.gymfit.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gymfit.R;
import com.example.gymfit.register.Registration;
import com.example.gymfit.register.SignOperations;
import com.example.gymfit.register.Verification;

public class contact extends Fragment {

    public contact() {
        // Required empty public constructor
    }

    EditText sendMsg,phone,email,name,msg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_contact, container, false);

        sendMsg=view.findViewById(R.id.sendMsg);
        phone=view.findViewById(R.id.phone);
        email=view.findViewById(R.id.email);
        name=view.findViewById(R.id.name);
        msg=view.findViewById(R.id.msg);

        sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString().toLowerCase().trim();
                String userName = name.getText().toString().trim();
                String userPhone = phone.getText().toString().trim();
                String userMsg = msg.getText().toString().trim();

                String validate = SignOperations.validateContact(userName,userPhone,userEmail,userMsg);

                if(validate.equals("Valid")) {
                    Toast.makeText(getContext(), "Successfully Submitted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(), validate + "", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
