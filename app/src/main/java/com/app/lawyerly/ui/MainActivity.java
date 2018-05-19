package com.app.lawyerly.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.app.lawyerly.R;
import com.app.lawyerly.ui.fragment.LawyerFragment;
import com.app.lawyerly.utils.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity implements LawyerFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_lawyer_tab:
                    return true;
                case R.id.navigation_second_tab:
                    return true;
                case R.id.navigation_third_tab:
                    return true;
                case R.id.navigation_fourth_tab:
                    return true;
                case R.id.navigation_fifth_tab:
                    return true;
            }
            return false;
        }
    };

    FrameLayout contentFrame;
    public TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.BloggerSansBoldTextAppearance);
        toolbar.setTitleTextColor(getResources().getColor(R.color.text_color));
        contentFrame = (FrameLayout) findViewById(R.id.content_frame);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);

        tabLayout = (TabLayout)findViewById(R.id.sliding_tabs);
        for (int i = 0; i < navigation.getChildCount(); i++) {
            Menu menu = navigation.getMenu();
            BottomNavigationViewHelper.removeTextLabel(navigation, menu.getItem(i).getItemId());
        }

        if (savedInstanceState == null)
            addFragment(getBaseContext(), LawyerFragment.newInstance("", ""), contentFrame.getId(), false);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void addFragment(Context context, Fragment fragment, int CONTENT_VIEW_ID, boolean addtobackstack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (addtobackstack)
            ft.addToBackStack(null);
        ft.add(CONTENT_VIEW_ID, fragment, fragment.getClass().getSimpleName()).commit();
    }
}
