package com.example.gymfit.effect;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.gymfit.R;

import java.util.Timer;
import java.util.TimerTask;

public class pagereffect {


    public void pagerEffect(final ViewPager viewPager, final int dotscount, final Context context, LinearLayout Dotspanel){

        final ImageView[] dots;
        final int[] currentPage = {0};
        final Timer[] timer = new Timer[1];
        final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
        final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
        final boolean[] userscroll = {false};


        dots = new ImageView[dotscount];

       for (int i = 0; i < dotscount; i++) {

           dots[i] = new ImageView(context);
           dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.dot));

           LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

           params.setMargins(8, 0, 8, 0);

           Dotspanel.addView(dots[i], params);

       }

       dots[0].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.active_dot));


       //Initial Timer
       final Handler handler = new Handler();
       final Runnable Update = new Runnable() {
           public void run() {
               if (currentPage[0] == dotscount) {
                   currentPage[0] = 0;
               }
               viewPager.setCurrentItem(currentPage[0]++, true);
           }
       };
       timer[0] = new Timer();
       timer[0].schedule(new TimerTask() { // task to be scheduled
           @Override
           public void run() {
               handler.post(Update);
           }
       }, DELAY_MS, PERIOD_MS);
       viewPager.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View view, MotionEvent motionEvent) {
               switch (motionEvent.getAction()){
                   case MotionEvent.ACTION_DOWN:
                       timer[0].cancel();
                       timer[0].purge();
                       userscroll[0] = true;
                       break;
                   case MotionEvent.ACTION_UP:
                       if (userscroll[0] == true) {

                           final Handler handler2 = new Handler();
                           final Runnable Update2 = new Runnable() {
                               public void run() {
                                   if (currentPage[0] == dotscount) {
                                       currentPage[0] = 0;
                                   }
                                   viewPager.setCurrentItem(currentPage[0]++, true);
                               }
                           };
                           timer[0] = new Timer();
                           timer[0].schedule(new TimerTask() { // task to be scheduled
                               @Override
                               public void run() {
                                   handler2.post(Update2);
                               }
                           }, DELAY_MS, PERIOD_MS);

                           userscroll[0] = false;
                       }
                       break;
               }
               return false;
           }
       });

       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
           }

           @Override
           public void onPageSelected(int position) {


               for (int i = 0; i < dotscount; i++) {
                   dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.dot));
               }

               dots[position].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.active_dot));
           }

           @Override
           public void onPageScrollStateChanged(int state) {


               if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                   timer[0].cancel();
                   timer[0].purge();
                   userscroll[0] = true;
               }
               else if (state == ViewPager.SCROLL_STATE_IDLE) {
                   if (userscroll[0] == true) {

                       final Handler handler2 = new Handler();
                       final Runnable Update2 = new Runnable() {
                           public void run() {
                               if (currentPage[0] == dotscount) {
                                   currentPage[0] = 0;
                               }
                               viewPager.setCurrentItem(currentPage[0]++, true);
                           }
                       };
                       timer[0] = new Timer();
                       timer[0].schedule(new TimerTask() { // task to be scheduled
                           @Override
                           public void run() {
                               handler2.post(Update2);
                           }
                       }, DELAY_MS, PERIOD_MS);

                       userscroll[0] = false;
                   }
               }
           }
       });
   }

}
