package dj.example.main.uiutils;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import dj.example.main.activities.MyApplication;

/**
 * Created by User on 18-12-2016.
 */

public class UiRandomUtils {

    private static UiRandomUtils randomUtils;
    public static UiRandomUtils getInstance(){
        if (randomUtils == null)
            randomUtils = new UiRandomUtils();
        return randomUtils;
    }

    public void startAnim(View view, int animResID){
        try {
            Animation anim = AnimationUtils.loadAnimation(MyApplication.getInstance(), animResID);
            view.startAnimation(anim);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }


    public void addSnapper(RecyclerView recyclerView, int gravity){
        SnapHelper snapHelper = new GravitySnapHelper(gravity);
        snapHelper.attachToRecyclerView(recyclerView);
    }
}
