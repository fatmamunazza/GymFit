package com.example.gymfit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.gymfit.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerCourseAdapter  extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    private List<Integer> slideShowImages = new ArrayList();
    private List<Integer> textShow = new ArrayList();
    private List<Integer> titleShow = new ArrayList();

    public ViewPagerCourseAdapter(Context home) {
        this.context=home;
        slideShowImages.add(R.drawable.squat);
        slideShowImages.add(R.drawable.deadlift);
        slideShowImages.add(R.drawable.legpress1);
        slideShowImages.add(R.drawable.chest);
        slideShowImages.add(R.drawable.lunge);
        slideShowImages.add(R.drawable.bench);

        titleShow.add(R.string.squat);
        titleShow.add(R.string.deadlift);
        titleShow.add(R.string.legPress);
        titleShow.add(R.string.chestFly);
        titleShow.add(R.string.lunge);
        titleShow.add(R.string.benchPress);

        textShow.add(R.string.squatPara);
        textShow.add(R.string.deadliftPara);
        textShow.add(R.string.legPressPara);
        textShow.add(R.string.chestFlyPara);
        textShow.add(R.string.lungePara);
        textShow.add(R.string.benchPressPara);
    }

    @Override
    public int getCount() {
        return slideShowImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {


        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.course_viewpager, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView title = (TextView) view.findViewById(R.id.viewpager_title);
        TextView text = (TextView) view.findViewById(R.id.viewpager_text);

        imageView.setImageResource(slideShowImages.get(position));
        title.setText(titleShow.get(position));
        text.setText(textShow.get(position));

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}
