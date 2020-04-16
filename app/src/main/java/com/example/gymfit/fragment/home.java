package com.example.gymfit.fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.gymfit.R;
import com.example.gymfit.adapter.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;
import java.util.jar.Manifest;

import com.example.gymfit.adapter.ViewPagerCourseAdapter;
import com.example.gymfit.adapter.ViewPagerTrainerAdapter;
import com.example.gymfit.effect.pagereffect;


public class home extends Fragment {

    ViewPager viewPager;
    LinearLayout Dotspanel;
    private int dotscount;

    ViewPager viewPagerCourse;
    LinearLayout DotspanelCourse;
    private int dotscountCourse;

    ViewPager viewPagerTrainer;
    LinearLayout DotspanelTrainer;
    private int dotscountTrainer;

    private ImageView[] dots;
    final int[] currentPage = {0};
    final Timer[] timer = new Timer[1];
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
    final boolean[] userscroll = {false};

   VideoView videoView;

    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_home, container, false);

         Dotspanel=view.findViewById(R.id.SliderDots);
         viewPager=view.findViewById(R.id.viewPager);
         videoView=view.findViewById(R.id.videoView);

         videoView.setVideoURI(Uri.parse("android.resources://com.example.gymfit/" + R.raw.sample));
         videoView.setMediaController(new MediaController(getContext()));
         videoView.requestFocus();
         videoView.start();


        DotspanelCourse=view.findViewById(R.id.SliderDotsCourse);
        viewPagerCourse=view.findViewById(R.id.viewPagerCourse);

        DotspanelTrainer=view.findViewById(R.id.SliderDotsTrainer);
        viewPagerTrainer=view.findViewById(R.id.viewPagerTrainer);


       if(getContext()!=null){
           ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());
           viewPager.setAdapter(viewPagerAdapter);
           dotscount = viewPagerAdapter.getCount();
           pagereffect pg=new pagereffect();
           pg.pagerEffect(viewPager,dotscount,getContext(),Dotspanel);

           ViewPagerCourseAdapter viewPagerAdap = new ViewPagerCourseAdapter(getContext());
           viewPagerCourse.setAdapter(viewPagerAdap);
           dotscountCourse = viewPagerAdap.getCount();
           pagereffect pg2=new pagereffect();
           pg2.pagerEffect(viewPagerCourse,dotscountCourse,getContext(),DotspanelCourse);

           ViewPagerTrainerAdapter viewPagerTrainerAdapter = new ViewPagerTrainerAdapter(getContext());
           viewPagerTrainer.setAdapter(viewPagerTrainerAdapter);
           dotscountTrainer = viewPagerTrainerAdapter.getCount();

           dots = new ImageView[dotscountTrainer];

           for (int i = 0; i < dotscountTrainer; i++) {

               dots[i] = new ImageView(getContext());
               dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.blackdot));

               LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

               params.setMargins(8, 0, 8, 0);

               DotspanelTrainer.addView(dots[i], params);

           }

           dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));


           //Initial Timer
           final Handler handler = new Handler();
           final Runnable Update = new Runnable() {
               public void run() {
                   if (currentPage[0] == dotscountTrainer) {
                       currentPage[0] = 0;
                   }
                   viewPagerTrainer.setCurrentItem(currentPage[0]++, true);
               }
           };
           timer[0] = new Timer();
           timer[0].schedule(new TimerTask() { // task to be scheduled
               @Override
               public void run() {
                   handler.post(Update);
               }
           }, DELAY_MS, PERIOD_MS);
           viewPagerTrainer.setOnTouchListener(new View.OnTouchListener() {
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
                                       if (currentPage[0] == dotscountTrainer) {
                                           currentPage[0] = 0;
                                       }
                                       viewPagerTrainer.setCurrentItem(currentPage[0]++, true);
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

           viewPagerTrainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
               @Override
               public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               }

               @Override
               public void onPageSelected(int position) {
                    if(getContext()!=null){
                        for (int i = 0; i < dotscountTrainer; i++) {
                            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.blackdot));
                        }

                        dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

                    }

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
                                   if (currentPage[0] == dotscountTrainer) {
                                       currentPage[0] = 0;
                                   }
                                   viewPagerTrainer.setCurrentItem(currentPage[0]++, true);
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
        return view;
    }
}
