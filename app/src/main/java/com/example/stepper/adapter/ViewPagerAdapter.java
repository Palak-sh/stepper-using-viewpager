package com.example.stepper.adapter;

import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.stepper.fragments.Hobby_Fragment;
import com.example.stepper.fragments.Personal_Details_Fragment;
import com.example.stepper.fragments.Qualification_Fragment;
import com.example.stepper.fragments.Work_Experience_Fragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Personal_Details_Fragment();
        }else if(position==1){
            return new Qualification_Fragment();
        }else if(position==2){
            return new Work_Experience_Fragment();
        }else{
            return new Hobby_Fragment();
        }

    }

    @Override
    public int getCount() {
        return 4;
    }
  
}
