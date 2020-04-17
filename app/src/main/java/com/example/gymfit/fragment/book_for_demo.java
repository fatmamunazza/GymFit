package com.example.gymfit.fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.gymfit.R;

public class book_for_demo extends Fragment {

    public book_for_demo() {
        // Required empty public constructor
    }
    VideoView videoView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_book_for_demo, container, false);

        videoView=view.findViewById(R.id.videoView);


        videoView.setVideoURI(Uri.parse("https://munazza123.000webhostapp.com/sample.mp4"));
        videoView.setMediaController(new MediaController(getContext()));
        videoView.start();

        return view;
    }
}
