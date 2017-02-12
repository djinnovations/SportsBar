package com.sportsbar.main.activities;

import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sportsbar.main.uiutils.MyGestureListener;

import butterknife.ButterKnife;
import dj.sportsbar.main.R;

/**
 * Created by User on 07-02-2017.
 */

public abstract class BaseDrawerActivity extends BaseActivity {

    protected FrameLayout container;
    protected Toolbar toolbar;
    protected ImageView imvHeaderMenu;
    protected ImageView imvHeaderSearch;
    protected TextView tvnHeaderTitle;

    protected GestureDetector gestureDetector;

    protected abstract MyGestureListener getGestureListener();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_drawer_base);
        container = (FrameLayout) findViewById(R.id.container);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        tvnHeaderTitle = (TextView) findViewById(R.id.tvnHeaderTitle);
        imvHeaderMenu = (ImageView) findViewById(R.id.imvHeaderMenu);
        imvHeaderSearch = (ImageView) findViewById(R.id.imvHeaderSearch);
        LayoutInflater.from(this).inflate(layoutResID, container, true);
        ButterKnife.bind(this);
        gestureDetector = new GestureDetector(this, getGestureListener());
    }

    @Override
    public ProgressBar getProgressBar() {
        return ((ProgressBar) findViewById(R.id.progressBar));
    }
}
