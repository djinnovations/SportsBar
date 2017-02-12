package com.sportsbar.main.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.sportsbar.main.fragments.CricketMatchDisplayFragment;
import com.sportsbar.main.fragments.MainActivityFragment;
import com.sportsbar.main.model.ThumbnailData;
import com.sportsbar.main.uiutils.MyGestureListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import dj.sportsbar.main.R;

public class MainActivity extends BaseDrawerActivity {

    private static final String TAG = "MainActivity";
    private MainActivityFragment mainActivityFragment;
    private boolean isHomeMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Runnable runnable = new Runnable() {
            public void run() {
                getSupportFragmentManager().beginTransaction().replace(container.getId(),
                        mainActivityFragment = new MainActivityFragment()).commit();
            }
        };
        MyApplication.getInstance().getUiHandler().postDelayed(runnable, 50);
        for (int i = 0; i<20; i++){
            datalist.add(new ThumbnailData(String.valueOf(i), null, null));
        }
    }

    List<ThumbnailData> datalist = new ArrayList<>();

    public List<ThumbnailData> getSampleData(){
        return datalist;
    }

    @Override
    public Activity getSelf() {
        return this;
    }

    @Override
    public View getViewForLayoutAccess() {
        return progressBar;
    }

    private final String MODE_HOME = "home";
    private final String MODE_MATCHES = "matches";
    private String CURRENT_MODE = MODE_HOME;

    @Override
    protected MyGestureListener getGestureListener() {
        return new MyGestureListener() {
            @Override
            public void onSwipeLeftToRight() {
                Log.d(TAG, "onSwipeLeftToRight");
                if (CURRENT_MODE.equalsIgnoreCase(MODE_HOME)){
                    transactMatchesFragment(R.anim.slide_in_from_right, R.anim.slide_out_into_right);
                }
            }

            @Override
            public void onSwipeRightToLeft() {
                Log.d(TAG, "onSwipeRightToLeft");
            }

            @Override
            public void onSwipeBottomToTop() {
                Log.d("djgest", "onSwipeBottomToTop");
            }

            @Override
            public void onSwipeTopToBottom() {
                Log.d("djgest", "onSwipeTopToBottom");
            }
        };
    }


    private CricketMatchDisplayFragment matchDisplayFragment;
    public void transactMatchesFragment(int enterAnimRes, int exitAnimRes){
        isHomeMode = false;
        FragmentTransaction manager = getSupportFragmentManager().beginTransaction();
        manager.setCustomAnimations(enterAnimRes, exitAnimRes);
        manager.replace(container.getId(), matchDisplayFragment = new CricketMatchDisplayFragment()).commit();
    }


    public void transactHomeFragment(int enterAnimRes, int exitAnimRes){
        isHomeMode = false;
        FragmentTransaction manager = getSupportFragmentManager().beginTransaction();
        manager.setCustomAnimations(enterAnimRes, exitAnimRes);
        manager.replace(container.getId(), mainActivityFragment = new MainActivityFragment()).commit();
    }

}
