package com.example.sapana.nearbycineplex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Button;

public class Theatre_Show_List extends FragmentActivity {

    ViewPager viewPager=null ;
    Button ctcbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre__show__list);
        viewPager=(ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new OurAdapter(fragmentManager));

    }

    class OurAdapter extends FragmentStatePagerAdapter {
        public OurAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d("dit","get item position is called");
            Fragment fragment=null;
            if(position==0){
                fragment=new FragmentToday();}//Dynamic Method Dispatch

            if(position==1)
            {
                fragment=new FragmentTomorrow();
            }
            if(position==2)
            {
                fragment=new FragmentWhen();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            Log.d("dit","get count is called");

            return 3;//There are three tabs so we return 3.It should be returned manually.
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position==0)
            {
                return "Today";

            }
            if(position==1)
            {
                return "Tomorrow";

            }
            if(position==2)
            {
                return "Saturday";

            }
            return null;
        }
    }
    }
