package com.example.gymfit.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.gymfit.R;

public class time_table extends Fragment {

    public time_table() {
        // Required empty public constructor
    }

    EditText selectDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_time_table, container, false);

        selectDay=view.findViewById(R.id.day_select);


        selectDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View menuItem=getView().findViewById(R.id.day_select);

                //Context wrapper = new ContextThemeWrapper(getContext(), R.style.popupTheme);

                PopupMenu popupMenu=new PopupMenu(getContext(),menuItem);
                popupMenu.getMenuInflater().inflate(R.menu.mymenu,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        selectDay.setText(" " + item.getTitle() + " ");
                        return true;
                    }

                });
                popupMenu.setGravity(Gravity.RIGHT);
                popupMenu.show();

            }
        });
        return view;
    }
}
