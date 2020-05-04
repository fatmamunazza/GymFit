package com.example.gymfit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymfit.fragment.about;
import com.example.gymfit.fragment.book_for_demo;
import com.example.gymfit.fragment.contact;
import com.example.gymfit.fragment.course;
import com.example.gymfit.fragment.home;
import com.example.gymfit.fragment.cerification;
import com.example.gymfit.fragment.time_table;
import com.google.android.material.navigation.NavigationView;

public class MainScreen extends AppCompatActivity {

   FrameLayout mainscreenContainer;
   NavigationView navigationDrawerLayout;
   public DrawerLayout drawerLayout;
   ImageView menu;
   LinearLayout actionLayout;
   TextView gym,fit;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        mainscreenContainer=findViewById(R.id.container_mainscreen);
        navigationDrawerLayout=findViewById(R.id.navigation_drawer_view);
        drawerLayout=findViewById(R.id.drawerLayout);
        actionLayout=findViewById(R.id.actionLayout);
        menu=actionLayout.findViewById(R.id.menu_img);
        gym=actionLayout.findViewById(R.id.gym);
        fit=actionLayout.findViewById(R.id.fit);

        gym.setVisibility(View.VISIBLE);
        fit.setVisibility(View.VISIBLE);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        Fragment home=new home();
        getSupportFragmentManager().beginTransaction().add(R.id.container_mainscreen, home).commit();


       navigationDrawerLayout.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               Fragment fr;
               switch (menuItem.getItemId()) {
                   case R.id.home_drawer: {
                       fr=new home();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;

                   }
                   case R.id.about_drawer: {
                       fr=new about();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;

                   }
                   case R.id.courses_drawer: {
                       fr=new course();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                       fit.setText("COURSES");
                       gym.setVisibility(View.GONE);
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }

                   case R.id.contact_drawer: {
                       fr=new contact();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                       fit.setText("CONTACT US");
                       gym.setVisibility(View.GONE);
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }
                   case R.id.certification_drawer: {
                       fr=new cerification();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                       fit.setText("CERTIFICATION");
                       gym.setVisibility(View.GONE);
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }
                   case R.id.feedback_drawer: {
                      /* fr=new feedback();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                       fit.setText("FEEDBACK FORM");
                       gym.setVisibility(View.GONE);
                       drawerLayout.closeDrawer(GravityCompat.START);*/

                       String[] s={"fatmamunazza@gmail.com"};
                       Intent intent = new Intent(Intent.ACTION_SENDTO);
                       intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                       intent.putExtra(Intent.EXTRA_EMAIL, s);
                       intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback or any Complaints");
                       if (intent.resolveActivity(getPackageManager()) != null) {
                           startActivity(intent);
                       }
                       else{
                           Toast.makeText(MainScreen.this, "You have no email clients installed in your mobile.", Toast.LENGTH_SHORT).show();
                       }
                       drawerLayout.closeDrawer(GravityCompat.START);

                       return false;
                   }
                   case R.id.table_drawer: {
                       fr=new time_table();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                       fit.setText("TIME TABLE");
                       gym.setVisibility(View.GONE);
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }
                   case R.id.demo_drawer: {
                       fr=new book_for_demo();
                       getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                       fit.setText("BOOK FOR DEMO");
                       gym.setVisibility(View.GONE);
                       drawerLayout.closeDrawer(GravityCompat.START);
                       return false;
                   }
                   case R.id.rate_drawer: {
                   }
                   case R.id.share_drawer: {
                       String poem_string = getString(R.string.home_share_content);

                       Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.share);
                       String  path = MediaStore.Images.Media.insertImage(getContentResolver(), b, "Title", null);


                       if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//
                           Intent share = new Intent(Intent.ACTION_SEND);
                           share.setType("text/*");
                           Uri file = Uri.parse(path);
                           share.putExtra(Intent.EXTRA_STREAM,file);
                           share.putExtra(Intent.EXTRA_TEXT, poem_string);
                           startActivity(Intent.createChooser(share, "Share Via"));
                       }
                       else{
                           ActivityCompat.requestPermissions(MainScreen.this,
                                   new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                   200);
                       }
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
