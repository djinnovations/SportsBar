package com.sportsbar.main.utils;

import android.app.Activity;
import android.widget.ImageView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.sportsbar.main.uiutils.ResourceReader;

import com.sportsbar.main.activities.MyApplication;

/**
 * Created by User on 26-01-2017.
 */

public class RandomUtils {

    private static RandomUtils randomUtils;
    private String TAG = "RandomUtils";

    public static RandomUtils getInstance() {
        if (randomUtils == null)
            randomUtils = new RandomUtils();
        return randomUtils;
    }

    private RandomUtils() {

    }


    public void launchNormalSignIn(Activity activity){
        /*Intent intent = new Intent(activity, AwignNormalLoginActivity.class);
        activity.startActivity(intent);*/
    }


    public void changeDrawable(ImageView imageView, IIcon icon, int coloresId) {
        imageView.setImageDrawable(new IconicsDrawable(MyApplication.getInstance())
                .icon(icon)
                .color(ResourceReader.getInstance().getColorFromResource(coloresId))
                .sizeDp(60));
    }
}
