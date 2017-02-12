package com.sportsbar.main.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.androidquery.callback.AjaxStatus;
import com.google.gson.JsonSyntaxException;
import com.sportsbar.main.fragments.SbSocialLoginFragment;
import com.sportsbar.main.utils.NetworkResultValidator;
import com.sportsbar.main.utils.support.SocialLoginUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import dj.sportsbar.main.R;

/**
 * Created by User on 25-01-2017.
 */

public class SocialLoginActivity extends BaseActivity {

    private SocialLoginUtil mSocialLoginInstance;

    @Override
    public ProgressBar getProgressBar() {
        return progressBar;
    }

    @Override
    public Activity getSelf() {
        return this;
    }

    @Override
    public View getViewForLayoutAccess() {
        return progressBar;
    }

    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.llContainer)
    LinearLayout llContainer;

    private SbSocialLoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_social);
        ButterKnife.bind(this);

        //mSocialLoginInstance = SocialLoginUtil.getInstance();
        Runnable runnable = new Runnable() {
            public void run() {
                getSupportFragmentManager().beginTransaction().replace(llContainer.getId(),
                        loginFragment = new SbSocialLoginFragment()).commit();
            }
        };
        MyApplication.getInstance().getUiHandler().postDelayed(runnable, 200);
    }

    public SocialLoginUtil getmSocialLoginInstance() {
        return mSocialLoginInstance;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mSocialLoginInstance.handleActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //mSocialLoginInstance.onActivityStart(this);
    }

    @Override
    public void serverCallEnds(int id, String url, Object json, AjaxStatus status) {
        super.serverCallEnds(id, url, json, status);
        if (id == SOCIAL_LOGIN_CALL) {
            try {
                boolean success = NetworkResultValidator.getInstance().isResultOK(url, (String) json, status, null,
                        progressBar, this);
                if (success) {
                    /*LoginResponse response = new Gson().fromJson((String) json, LoginResponse.class);
                    response.onParse();*/
                    return;
                }
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
            //ColoredSnackbar.alert(Snackbar.make(progressBar, "UNKNOWN_ERR", Snackbar.LENGTH_SHORT)).show();
        }
    }
}
