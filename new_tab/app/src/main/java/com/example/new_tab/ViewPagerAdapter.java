package com.example.new_tab;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super (fragmentActivity);
    }
    @NonNull @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new Tab1();
            case 1: return new Tab2();
            case 2: return new Ta3();
            default: return new Tab1();
        }
    }
    @Override
    public int getItemCount() {
        return 3;
    }

}