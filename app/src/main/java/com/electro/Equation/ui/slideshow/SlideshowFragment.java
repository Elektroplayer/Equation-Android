package com.electro.Equation.ui.slideshow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.electro.Equation.R;

public class SlideshowFragment extends Fragment {

    //private SlideshowViewModel slideshowViewModel;
    private Intent browserIntent;
    private ImageView image;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Elektroplayer/Equation-Android"));

        image = root.findViewById(R.id.imageGitHub);
        image.setOnClickListener(v -> startActivity(browserIntent));

        return root;
    }
}