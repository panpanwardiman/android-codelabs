package com.example.latihancodelabs.TabExperiment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;

import com.example.latihancodelabs.R;
import com.google.android.material.tabs.TabLayout;

public class TabExperimentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_experiment);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_label1)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_label2)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab_label3)));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}