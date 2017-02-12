package com.sportsbar.main.activities;

import android.app.Application;
import android.os.Handler;

/**
 * Created by DJphy on 28-09-2016.
 */
public class MyApplication extends Application {

    public static final String API_KEY_TW = "";
    public static final String API_SECRET_TW = "";
    public static final String OAUTH_WEBCLIENT_ID_GL = "";
    public static final String ERR_MSG_NETWORK = "network ERR";


    private static MyApplication ourInstance;
    public static MyApplication getInstance(){
        return ourInstance;
    }

    public interface MenuSelectionListener {
        void onMenuSelected(Object data);
    }

    private Handler uiHandler;
    public Handler getUiHandler() {
        return uiHandler;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        uiHandler = new Handler();
    }
}
