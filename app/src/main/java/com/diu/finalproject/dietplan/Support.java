package com.diu.finalproject.dietplan;


import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.diu.finalproject.dietplan.ContactFragments.PagerAdapter;
import com.diu.finalproject.dietplan.ContactFragments.Tab1;
import com.diu.finalproject.dietplan.ContactFragments.Tab2;
import com.diu.finalproject.dietplan.ContactFragments.Tab3;

public class Support extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        Log.d(TAG, "onCreate: Starting.");

        mViewPager = (ViewPager) findViewById(R.id.container);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1(), "Consultant");
        adapter.addFragment(new Tab2(), "Chat");
        adapter.addFragment(new Tab3(), "Profile");

        mViewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

}