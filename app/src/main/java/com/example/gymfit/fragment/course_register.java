package com.example.gymfit.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymfit.R;


import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static com.example.gymfit.common.courseString.course_para1;
import static com.example.gymfit.common.courseString.course_para2;
import static com.example.gymfit.common.courseString.course_para3;
import static com.example.gymfit.common.courseString.course_para4;
import static com.example.gymfit.common.courseString.course_para5;
import static com.example.gymfit.common.courseString.course_para6;
import static com.example.gymfit.common.courseString.course_time1;
import static com.example.gymfit.common.courseString.course_time2;
import static com.example.gymfit.common.courseString.course_time3;
import static com.example.gymfit.common.courseString.course_time4;
import static com.example.gymfit.common.courseString.course_time5;
import static com.example.gymfit.common.courseString.course_time6;
import static com.example.gymfit.common.courseString.course_title1;
import static com.example.gymfit.common.courseString.course_title2;
import static com.example.gymfit.common.courseString.course_title3;
import static com.example.gymfit.common.courseString.course_title4;
import static com.example.gymfit.common.courseString.course_title5;
import static com.example.gymfit.common.courseString.course_title6;


public class course_register extends Fragment {


    public course_register() {
        // Required empty public constructor
    }

    Spinner state,city;
    TextView headingTitle,registerTitle,registerTime,registerPara,enroll;
    EditText name,phone,email,address,submit;
    ImageView registerImage;
    String TAG ="main";
    final int UPI_PAYMENT = 123;

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

        /*tvName=view.findViewById(R.id.tvName);
        tvPhone=view.findViewById(R.id.tvPhone);
        tvEmail=view.findViewById(R.id.tvEmail);
        tvAddress=view.findViewById(R.id.tvAddress);

        name=view.findViewById(R.id.name);
        phone=view.findViewById(R.id.phone);
        email=view.findViewById(R.id.email);
        address=view.findViewById(R.id.address);

        submit=view.findViewById(R.id.submit);*/

       // headingTitle.setText(viewName);


        switch (viewName){
            case course_title1:
                registerImage.setImageResource(R.drawable.register1);
                registerTitle.setText(course_title1);
                registerTime.setText(course_time1);
                registerPara.setText(course_para1);
                break;
            case course_title2:
                registerImage.setImageResource(R.drawable.register2);
                registerTitle.setText(course_title2);
                registerTime.setText(course_time2);
                registerPara.setText(course_para2);
                break;
            case course_title3:
                registerImage.setImageResource(R.drawable.register3);
                registerTitle.setText(course_title3);
                registerTime.setText(course_time3);
                registerPara.setText(course_para3);
                break;
            case course_title4:
                registerImage.setImageResource(R.drawable.register4);
                registerTitle.setText(course_title4);
                registerTime.setText(course_time4);
                registerPara.setText(course_para4);
                break;
            case course_title5:
                registerImage.setImageResource(R.drawable.register5);
                registerTitle.setText(course_title5);
                registerTime.setText(course_time5);
                registerPara.setText(course_para5);
                break;
            case course_title6:
                registerImage.setImageResource(R.drawable.register6);
                registerTitle.setText(course_title6);
                registerTime.setText(course_time6);
                registerPara.setText(course_para6);
                break;
            default:
                break;
        }


        /*name.addTextChangedListener(new TextWatcher() {
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
        });*/

        /*submit.setOnClickListener(new View.OnClickListener() {
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
*/
       /* state=view.findViewById(R.id.state);
        city=view.findViewById(R.id.city);*/
/*
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(),R.array.state_array,R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        state.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(getContext(),R.array.state_array,R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        state.setAdapter(adapter1);*/

        enroll=view.findViewById(R.id.enroll);
        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               payUsingUpi("MUNAZZA","fatmakaniz1996@okicici","Enroll for course KettleBell","500");
            }
        });

        return view;
    }


    void payUsingUpi(  String name,String upiId, String note, String amount) {
        String GOOGLE_PAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";

        Log.e("main ", "name "+name +"--up--"+upiId+"--"+ note+"--"+amount);
        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", name)
                .appendQueryParameter("tn", note)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                .build();
        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);
        // upiPayIntent.setPackage(GOOGLE_PAY_PACKAGE_NAME);

        // will always show a dialog to user to choose an app
        Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");
        // check if intent resolves
        if(null != chooser.resolveActivity(getActivity().getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(getContext(),"No UPI app found, please install one to continue",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("main ", "response "+resultCode );
        switch (requestCode) {
            case UPI_PAYMENT:
                if ((RESULT_OK == resultCode) || (resultCode == 11)) {
                    if (data != null) {
                        String trxt = data.getStringExtra("response");
                        Log.e("UPI", "onActivityResult: " + trxt);
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add(trxt);
                        upiPaymentDataOperation(dataList);
                    } else {
                        Log.e("UPI", "onActivityResult: " + "Return data is null");
                        ArrayList<String> dataList = new ArrayList<>();
                        dataList.add("nothing");
                        upiPaymentDataOperation(dataList);
                    }
                } else {
                    //when user simply back without payment
                    Log.e("UPI", "onActivityResult: " + "Return data is null");
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
                break;
        }
    }
    private void upiPaymentDataOperation(ArrayList<String> data) {
        if (isConnectionAvailable(getContext())) {
            String str = data.get(0);
            Log.e("UPIPAY", "upiPaymentDataOperation: "+str);
            String paymentCancel = "";
            if(str == null) str = "discard";
            String status = "";
            String approvalRefNo = "";
            String response[] = str.split("&");
            for (int i = 0; i < response.length; i++) {
                String equalStr[] = response[i].split("=");
                if(equalStr.length >= 2) {
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                        status = equalStr[1].toLowerCase();
                    }
                    else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalRefNo = equalStr[1];
                    }
                }
                else {
                    paymentCancel = "Payment cancelled by user.";
                }
            }
            if (status.equals("success")) {
                //Code to handle successful transaction here.
                Toast.makeText(getContext(), "Transaction successful.", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "payment successfull: "+approvalRefNo);
            }
            else if("Payment cancelled by user.".equals(paymentCancel)) {
                Toast.makeText(getContext(), "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "Cancelled by user: "+approvalRefNo);
            }
            else {
                Toast.makeText(getContext(), "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
                Log.e("UPI", "failed payment: "+approvalRefNo);
            }
        } else {
            Log.e("UPI", "Internet issue: ");
            Toast.makeText(getContext(), "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
        }
    }
    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable()) {
                return true;
            }
        }
        return false;
    }
}
