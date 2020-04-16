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

public class ViewPagerTrainerAdapter  extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    private List<Integer> slideShowImages = new ArrayList();
    private List<Integer> textShow = new ArrayList();
    private List<Integer> titleShow = new ArrayList();

    public ViewPagerTrainerAdapter(Context home) {
        this.context=home;
        slideShowImages.add(R.drawable.t1);
        slideShowImages.add(R.drawable.t2);
        slideShowImages.add(R.drawable.t3);
        slideShowImages.add(R.drawable.t4);
        slideShowImages.add(R.drawable.t3);
        slideShowImages.add(R.drawable.t3);

        titleShow.add(R.string.trainer_name_1);
        titleShow.add(R.string.trainer_name_2);
        titleShow.add(R.string.trainer_name_3);
        titleShow.add(R.string.trainer_name_4);
        titleShow.add(R.string.trainer_name_5);
        titleShow.add(R.string.trainer_name_6);

        textShow.add(R.string.trainer_prof_1);
        textShow.add(R.string.trainer_prof_2);
        textShow.add(R.string.trainer_prof_3);
        textShow.add(R.string.trainer_prof_4);
        textShow.add(R.string.trainer_prof_5);
        textShow.add(R.string.trainer_prof_6);
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
        View view = layoutInflater.inflate(R.layout.trainer_viewpager, null);

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
