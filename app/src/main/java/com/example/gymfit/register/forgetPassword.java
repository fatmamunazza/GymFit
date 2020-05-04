package com.example.gymfit.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymfit.R;

public class forgetPassword extends AppCompatActivity {


    TextView tvPassword,tvConfirmPassword,changePassword;
    EditText password,confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        tvPassword=findViewById(R.id.tvPassword);
        tvConfirmPassword=findViewById(R.id.tvconfirmPassword);

        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirm_password);
        changePassword=findViewById(R.id.changePassword);




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


        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userPassword = password.getText().toString();
                String userConfirmPassword = confirmPassword.getText().toString();


                String validate = SignOperations.validatePassword(userPassword,userConfirmPassword);

                if(validate.equals("Valid")) {
                    Intent i = new Intent(forgetPassword.this, SuccessScreenForChangePassword.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(forgetPassword.this, validate + "", Toast.LENGTH_SHORT).show();
                }




            }
        });



    }




}
