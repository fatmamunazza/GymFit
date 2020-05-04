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

public class ViewPagerAdapter extends PagerAdapter {

       private Context context;
    private LayoutInflater layoutInflater;

    private List<Integer> slideShowImages = new ArrayList();
    private List<Integer> textShow = new ArrayList();

    public ViewPagerAdapter(Context home) {
        this.context=home;
        slideShowImages.add(R.drawable.banner);
        slideShowImages.add(R.drawable.banner2);
        slideShowImages.add(R.drawable.banner3);

        textShow.add(R.string.home_firstpage_para);
        textShow.add(R.string.home_secondpage_para);
        textShow.add(R.string.home_thirdpage_para);
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
        View view = layoutInflater.inflate(R.layout.viewpage_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        TextView para = (TextView) view.findViewById(R.id.viewpager_text);

        imageView.setImageResource(slideShowImages.get(position));
        para.setText(textShow.get(position));

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
