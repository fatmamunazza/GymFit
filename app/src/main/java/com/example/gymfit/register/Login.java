package com.example.gymfit.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymfit.MainScreen;
import com.example.gymfit.R;

public class Login extends AppCompatActivity {

    TextView login,forget;
    LinearLayout register;
    EditText email,password;
    TextView tvEmail,tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        forget=findViewById(R.id.forget);

        password=findViewById(R.id.password);
        email=findViewById(R.id.email);

        tvPassword=findViewById(R.id.tvPassword);
        tvEmail=findViewById(R.id.tvEmail);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Login.this, Registration.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail = email.getText().toString().toLowerCase().trim();
                String userPassword = password.getText().toString();

                String validate = SignOperations.validateLoginUser(userEmail, userPassword);

                if(validate.equals("Valid")) {
                    Intent i=new Intent(Login.this, MainScreen.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Login.this, validate + "", Toast.LENGTH_SHORT).show();
                }

            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Login.this, RegistrationId.class);
                startActivity(i);
            }
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
    }
}
