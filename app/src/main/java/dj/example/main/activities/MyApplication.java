package dj.example.main.activities;

import android.app.Application;

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

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
    }
}
