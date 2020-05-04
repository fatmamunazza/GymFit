package com.example.gymfit.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymfit.MainActivity;
import com.example.gymfit.R;

public class Registration extends AppCompatActivity {

    TextView register,tvName,tvPhone,tvEmail,tvAddress,tvPassword,tvConfirmPassword;
    EditText name,phone,email,address,password,confirmPassword;
    LinearLayout login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        login=findViewById(R.id.layoutLogin);
        register=findViewById(R.id.register);

        tvName=findViewById(R.id.tvName);
        tvPhone=findViewById(R.id.tvPhone);
        tvEmail=findViewById(R.id.tvEmail);
        tvPassword=findViewById(R.id.tvPassword);
        tvConfirmPassword=findViewById(R.id.tvconfirmPassword);

        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirm_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Registration.this, Login.class);
                startActivity(i);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail = email.getText().toString().toLowerCase().trim();
                String userName = name.getText().toString();
                String userPhone = phone.getText().toString().trim();
                String userPassword = password.getText().toString();
                String userConfirmPassword = confirmPassword.getText().toString();


                String validate = SignOperations.validateUser(userName,userPhone,userEmail, userPassword,userConfirmPassword);

                if(validate.equals("Valid")) {
                    Intent i = new Intent(Registration.this, Verification.class);
                    i.putExtra("screenName", "registration");
                    i.putExtra("emailId",userEmail);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Registration.this, validate + "", Toast.LENGTH_SHORT).show();
                }
            }
        });


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

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvPassword.setVisibility(View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvConfirmPassword.setVisibility(View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });


    }
}
