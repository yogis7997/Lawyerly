package com.app.lawyerly.ui;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.app.lawyerly.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextAppearance(this, R.style.BloggerSansBoldTextAppearance);
        toolbar.setTitleTextColor(getResources().getColor(R.color.text_color));
        final Button button = (Button) findViewById(R.id.button2);
        AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();

        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);

        animationDrawable.start();

    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        onBackPressed();
        return super.getSupportParentActivityIntent();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
