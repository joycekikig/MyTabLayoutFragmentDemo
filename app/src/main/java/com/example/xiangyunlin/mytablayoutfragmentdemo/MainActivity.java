package com.example.xiangyunlin.mytablayoutfragmentdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {
    private FrameLayout mSimpleFrameLayout;
    private TabLayout mTabLayout;
    private ViewPager mSimpleViewPager;

    ViewPager simpleViewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example 1 of TabLayout

        /*
        // get the reference of FrameLayout and TabLayout
        mSimpleFrameLayout = (FrameLayout) findViewById(R.id.simpleFrameLayout);
        mTabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);

        // Create a new Tab named "First"
        TabLayout.Tab firstTab = mTabLayout.newTab();
        firstTab.setText("First"); // set the Text for the first Tab

        // first tab
        mTabLayout.addTab(firstTab); // add  the tab at in the TabLayout

        // Create a new Tab named "Second"
        TabLayout.Tab secondTab = mTabLayout.newTab();
        secondTab.setText("Second"); // set the Text for the second Tab
        mTabLayout.addTab(secondTab); // add  the tab  in the TabLayout

        // Create a new Tab named "Third"
        TabLayout.Tab thirdTab = mTabLayout.newTab();
        thirdTab.setText("Third"); // set the Text for the first Tab
        mTabLayout.addTab(thirdTab); // add  the tab at in the TabLayout

        // perform setOnTabSelectedListener event on TabLayout
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // get the current selected tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new Tab1();
                        break;
                    case 1:
                        fragment = new Tab2();
                        break;
                    case 2:
                        fragment = new Tab3();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        */

        // Example 2 of TabLayout Using ViewPager

        // get the reference of ViewPager and TabLayout
        mSimpleViewPager = (ViewPager) findViewById(R.id.simpleViewPager);
        mTabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);

        // Create a new Tab named "First"
        TabLayout.Tab firstTab = mTabLayout.newTab();
        firstTab.setText("First");
        mTabLayout.addTab(firstTab);

        // Create a new Tab named "Second"
        TabLayout.Tab secondTab = mTabLayout.newTab();
        secondTab.setText("Second");
        mTabLayout.addTab(secondTab);

        // Create a new Tab named "Third"
        TabLayout.Tab thirdTab = mTabLayout.newTab();
        thirdTab.setText("Third");
        mTabLayout.addTab(thirdTab);

        PagerAdapter adapter = new Pager(getSupportFragmentManager(), mTabLayout.getTabCount());
        mSimpleViewPager.setAdapter(adapter);

        // addOnPageChangeListener event change the tab on slide
        mSimpleViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        // addOnTabSelectedListener event change the tab on click
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mSimpleViewPager));

    }




}
