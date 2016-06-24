package com.example.constant.fragmentdemoxml;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Random;

/**
 * Created by Constant on 6/12/2016.
 */
public class FragmentClassA extends Fragment implements View.OnTouchListener {

    Random rnd;
    int color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_a,viewGroup,false);
        view.setOnTouchListener(this);
        rnd = new Random();
        runFadeOutAnimationOn(getActivity(),view);
        return view;
    }

    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            v.setBackgroundColor(color);
        }

        return true;
    }

    public static Animation runFadeOutAnimationOn(Activity ctx, View target) {
        Animation animation = AnimationUtils.loadAnimation(ctx,
                R.anim.slideright);
        target.startAnimation(animation);
        return animation;
    }
}
