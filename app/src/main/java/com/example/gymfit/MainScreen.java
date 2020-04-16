package com.example.gymfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.gymfit.fragment.about;
import com.example.gymfit.fragment.brochure;
import com.example.gymfit.fragment.contact;
import com.example.gymfit.fragment.course;
import com.example.gymfit.fragment.features;
import com.example.gymfit.fragment.feedback;
import com.example.gymfit.fragment.home;
import com.example.gymfit.fragment.resources;
import com.example.gymfit.fragment.time_table;
import com.google.android.material.navigation.NavigationView;

public class MainScreen extends AppCompatActivity {

   FrameLayout mainscreenContainer;
   NavigationView navigationDrawerLayout;
   public DrawerLayout drawerLayout;
   ImageView menu;
   LinearLayout actionLayout;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        mainscreenContainer=findViewById(R.id.container_mainscreen);
        navigationDrawerLayout=findViewById(R.id.navigation_drawer_view);
        drawerLayout=findViewById(R.id.drawerLayout);
        actionLayout=findViewById(R.id.actionLayout);
        menu=actionLayout.findViewById(R.id.menu_img);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        Fragment home=new time_table();
        getSupportFragmentManager().beginTransaction().add(R.id.container_mainscreen, home).commit();


       navigationDrawerLayout.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               Fragment fr;
               switch (menuItem.getItemId()) {
                   case R.id.home_drawer: {
                       fr=new home();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;

                   }
                   case R.id.about_drawer: {
                       fr=new about();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;

                   }
                   case R.id.courses_drawer: {
                       fr=new course();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }

                   case R.id.contact_drawer: {
                       fr=new contact();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }
                   case R.id.brochure_drawer: {
                       fr=new brochure();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }
                   case R.id.resources_drawer: {
                       fr=new resources();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }
                   case R.id.features_drawer: {
                       fr=new features();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }
                   case R.id.feedback_drawer: {
                       fr=new feedback();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }
                   case R.id.table_drawer: {
                       fr=new time_table();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }
                   default: {
                       return false;
                   }

               }

           }
       });


    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
