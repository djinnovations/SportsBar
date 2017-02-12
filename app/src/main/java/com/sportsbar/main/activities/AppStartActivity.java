package com.sportsbar.main.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import dj.sportsbar.main.R;
import com.sportsbar.main.fragments.AppStartFragment;

/**
 * Created by User on 02-02-2017.
 */

public class AppStartActivity extends BaseActivity{
    @Override
    public ProgressBar getProgressBar() {
        return null;
    }

    @Override
    public Activity getSelf() {
        return null;
    }

    @Override
    public View getViewForLayoutAccess() {
        return null;
    }

    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.llContainer)
    LinearLayout llContainer;

    private AppStartFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_app);
        ButterKnife.bind(this);

        Runnable runnable = new Runnable() {
            public void run() {
                getSupportFragmentManager().beginTransaction().replace(llContainer.getId(),
                        fragment = new AppStartFragment()).commit();
            }
        };
        MyApplication.getInstance().getUiHandler().postDelayed(runnable, 200);
    }

}
