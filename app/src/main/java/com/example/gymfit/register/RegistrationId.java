package com.example.gymfit.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymfit.R;

public class RegistrationId extends AppCompatActivity {

    TextView submit,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_id);


        submit=findViewById(R.id.submit);
        email=findViewById(R.id.email);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail = email.getText().toString().toLowerCase().trim();

                String validate = SignOperations.validateMail(userEmail);

                if(validate.equals("Valid")) {
                    Intent i=new Intent(RegistrationId.this, Verification.class);
                    i.putExtra("screenName","forgetPassword");
                    i.putExtra("emailId",userEmail);
                    startActivity(i);
                }
                else{
                    Toast.makeText(RegistrationId.this, validate + "", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
