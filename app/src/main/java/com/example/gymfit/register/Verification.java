package com.example.gymfit.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.example.gymfit.MainScreen;
import com.example.gymfit.R;

import org.json.JSONObject;

public class Verification extends AppCompatActivity {

    TextView verify,emailId;
    private EditText otpET1, otpET2, otpET3, otpET4, otpET5, otpET6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        final String screenName=getIntent().getExtras().getString("screenName");
        final String useremailId=getIntent().getExtras().getString("emailId");

        verify=findViewById(R.id.verify);
        emailId=findViewById(R.id.emailId);
        emailId.append(useremailId);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(otpET1.getText().length()!=0 && otpET2.getText().length()!=0 && otpET3.getText().length()!=0 && otpET4.getText().length()!=0 && otpET5.getText().length()!=0 && otpET6.getText().length()!=0){
                    if (screenName.equalsIgnoreCase("registration")) {
                        Intent i=new Intent(Verification.this, Login.class);
                        startActivity(i);
                    }
                    else {
                        Intent i=new Intent(Verification.this, forgetPassword.class);
                        startActivity(i);
                    }
                }
                else{
                    Toast.makeText(Verification.this, "Enter Verification Code", Toast.LENGTH_SHORT).show();

                }
            }
        });


        otpET1 = findViewById(R.id.otpET1);
        otpET2 = findViewById(R.id.otpET2);
        otpET3 = findViewById(R.id.otpET3);
        otpET4 = findViewById(R.id.otpET4);
        otpET5 = findViewById(R.id.otpET5);
        otpET6 = findViewById(R.id.otpET6);

        otpET1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i!=keyEvent.KEYCODE_DEL){
                    otpET2.requestFocus();
                }
                return false;
            }
        });
        otpET2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(i==KeyEvent.KEYCODE_DEL && keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                    otpET1.requestFocus(View.FOCUS_DOWN);
                }
                else if(otpET2.getText().length()==1){
                    otpET3.requestFocus();
                }
                else{
                    otpET2.requestFocus();
                }
                return false;
            }
        });
        otpET3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(i==KeyEvent.KEYCODE_DEL && keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                    otpET2.requestFocus(View.FOCUS_DOWN);

                }
                else if(otpET3.getText().length()==1){
                    otpET4.requestFocus();
                }
                else{
                    otpET3.requestFocus();
                }
                return false;
            }
        });
        otpET4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(i==KeyEvent.KEYCODE_DEL && keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                    otpET3.requestFocus(View.FOCUS_DOWN);

                }
                else if(otpET4.getText().length()==1){
                    otpET5.requestFocus();
                }
                else{
                    otpET4.requestFocus();
                }
                return false;
            }
        });
        otpET5.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(i==KeyEvent.KEYCODE_DEL && keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                    otpET4.requestFocus(View.FOCUS_DOWN);
                }
                else if(otpET5.getText().length()==1){
                    otpET6.requestFocus();
                }
                else{
                    otpET5.requestFocus();
                }
                return false;
            }
        });
        otpET6.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(i==KeyEvent.KEYCODE_DEL && keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                    otpET5.requestFocus(View.FOCUS_DOWN);
                }
                else{
                    otpET6.requestFocus();
                }
                return false;
            }
        });


        otpET1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){
                    otpET2.requestFocus();
                }
                else{
                    otpET1.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        otpET2.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){

                    otpET3.requestFocus();
                }
                else{
                    otpET2.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        otpET3.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){
                    otpET4.requestFocus();
                }
                else{
                    otpET3.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        otpET4.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){
                    otpET5.requestFocus();
                }
                else{
                    otpET4.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        otpET5.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==1){
                    otpET6.requestFocus();
                }
                else{
                    otpET5.requestFocus();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
        otpET6.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                otpET6.requestFocus();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });
    }
}
