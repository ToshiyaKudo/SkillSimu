package com.kudo1048.app.skillsimu;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class pageAdapter extends FragmentPagerAdapter {

    public pageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new testFragment1();
            case 1:
                return new testFragment2();
            case 2:
                return new masterFragment();
            default:
                return new testFragment3();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "スキルふりわけ";
            case 1:
                return "武器スキル";
            case 2:
                return "職業スキル";
            default:
                return "マスターＰ";
        }
    }
}
