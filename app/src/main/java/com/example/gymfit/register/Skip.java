package com.example.gymfit.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gymfit.MainScreen;
import com.example.gymfit.R;
import com.example.gymfit.adapter.ViewPagerAdapter;
import com.example.gymfit.effect.pagereffect;

public class Skip extends AppCompatActivity {

    Button checkLogin;
    TextView skip;
    ViewPager viewPager;
    LinearLayout Dotspanel;
    private int dotscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);
       

        checkLogin=findViewById(R.id.checkButton);
        skip=findViewById(R.id.skip);


        Dotspanel=findViewById(R.id.SliderDots);
        viewPager=findViewById(R.id.viewPager);

        if(getApplicationContext()!=null) {
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getApplicationContext());
            viewPager.setAdapter(viewPagerAdapter);
            dotscount = viewPagerAdapter.getCount();
            pagereffect pg = new pagereffect();
            pg.pagerEffect(viewPager, dotscount, getApplicationContext(), Dotspanel);
        }

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Skip.this, MainScreen.class);
                startActivity(i);
            }
        });

        checkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Skip.this, Login.class);
                startActivity(i);
            }
        });

    }
}
