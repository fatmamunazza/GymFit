package com.example.gymfit.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
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
    CardView weightLoose,cardio,yoga,fitness,karate,boxing,aerobics,bodyBuilding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_time_table, container, false);

        selectDay=view.findViewById(R.id.day_select);

        weightLoose=view.findViewById(R.id.view1);
        cardio=view.findViewById(R.id.view2);
        yoga=view.findViewById(R.id.view3);
        fitness=view.findViewById(R.id.view4);
        karate=view.findViewById(R.id.view5);
        boxing=view.findViewById(R.id.view6);
        aerobics=view.findViewById(R.id.view7);
        bodyBuilding=view.findViewById(R.id.view8);


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

                        switch(item.getTitle().toString()){
                            case "MONDAY":
                                weightLoose.setVisibility(View.VISIBLE);
                                cardio.setVisibility(View.VISIBLE);
                                yoga.setVisibility(View.VISIBLE);
                                fitness.setVisibility(View.VISIBLE);
                                karate.setVisibility(View.VISIBLE);
                                boxing.setVisibility(View.VISIBLE);
                                aerobics.setVisibility(View.VISIBLE);
                                bodyBuilding.setVisibility(View.VISIBLE);
                                break;
                            case "TUESDAY":
                                weightLoose.setVisibility(View.GONE);
                                cardio.setVisibility(View.VISIBLE);
                                yoga.setVisibility(View.GONE);
                                fitness.setVisibility(View.VISIBLE);
                                karate.setVisibility(View.VISIBLE);
                                boxing.setVisibility(View.VISIBLE);
                                aerobics.setVisibility(View.GONE);
                                bodyBuilding.setVisibility(View.VISIBLE);
                                break;
                            case "WEDNESDAY":
                                weightLoose.setVisibility(View.GONE);
                                cardio.setVisibility(View.GONE);
                                yoga.setVisibility(View.GONE);
                                fitness.setVisibility(View.VISIBLE);
                                karate.setVisibility(View.GONE);
                                boxing.setVisibility(View.GONE);
                                aerobics.setVisibility(View.GONE);
                                bodyBuilding.setVisibility(View.VISIBLE);
                                break;
                            case "THURSDAY":
                                weightLoose.setVisibility(View.GONE);
                                cardio.setVisibility(View.VISIBLE);
                                yoga.setVisibility(View.GONE);
                                fitness.setVisibility(View.GONE);
                                karate.setVisibility(View.GONE);
                                boxing.setVisibility(View.VISIBLE);
                                aerobics.setVisibility(View.VISIBLE);
                                bodyBuilding.setVisibility(View.GONE);
                                break;
                            case "FRIDAY":
                                weightLoose.setVisibility(View.GONE);
                                cardio.setVisibility(View.GONE);
                                yoga.setVisibility(View.VISIBLE);
                                fitness.setVisibility(View.GONE);
                                karate.setVisibility(View.GONE);
                                boxing.setVisibility(View.VISIBLE);
                                aerobics.setVisibility(View.GONE);
                                bodyBuilding.setVisibility(View.VISIBLE);
                                break;
                            case "SATURDAY":
                                weightLoose.setVisibility(View.VISIBLE);
                                cardio.setVisibility(View.GONE);
                                yoga.setVisibility(View.GONE);
                                fitness.setVisibility(View.GONE);
                                karate.setVisibility(View.GONE);
                                boxing.setVisibility(View.VISIBLE);
                                aerobics.setVisibility(View.VISIBLE);
                                bodyBuilding.setVisibility(View.VISIBLE);
                                break;
                            case "SUNDAY":
                                weightLoose.setVisibility(View.GONE);
                                cardio.setVisibility(View.VISIBLE);
                                yoga.setVisibility(View.GONE);
                                fitness.setVisibility(View.VISIBLE);
                                karate.setVisibility(View.GONE);
                                boxing.setVisibility(View.GONE);
                                aerobics.setVisibility(View.VISIBLE);
                                bodyBuilding.setVisibility(View.VISIBLE);
                                break;
                            default:
                                break;

                        }

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
