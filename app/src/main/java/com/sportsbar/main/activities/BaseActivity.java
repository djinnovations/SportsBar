package com.sportsbar.main.activities;

import android.support.design.widget.Snackbar;
import android.util.Log;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.sportsbar.main.uiutils.ColoredSnackbar;
import com.sportsbar.main.utils.IDUtils;
import com.sportsbar.main.utils.URLHelper;

/**
 * Created by User on 02-02-2017.
 */

public abstract class BaseActivity extends AppCoreActivity {

    private String TAG = "BaseActivity";

    public final int SOCIAL_LOGIN_CALL = IDUtils.generateViewId();
    public void queryForSocialLogin(JSONObject inputParams){
        startProgress();
        AjaxCallback ajaxCallback = getAjaxCallback(SOCIAL_LOGIN_CALL);
        ajaxCallback.method(AQuery.METHOD_POST);
        ajaxCallback.header("content-type", "application/json");
        String url = URLHelper.getInstance().getSocialLoginAPI();
        Log.d(TAG, "POST url- queryForSocialLogin()" + TAG + ": " + url);
        Map<String,Object> params = null;
        try {
            params = new ObjectMapper().readValue(inputParams.toString(), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (params == null){
            setErrMsg("Sign in Failed");
            return;
        }
        Log.d(TAG, "POST reqParams- queryForSocialLogin()" + TAG + ": " + params);
        getAQuery().ajax(url, params, String.class, ajaxCallback);
    }


    public void setErrMsg(String msg){
        ColoredSnackbar.alert(Snackbar.make(getViewForLayoutAccess(), msg, Snackbar.LENGTH_SHORT)).show();
    }

    public void setWarningMsg(String msg){
        ColoredSnackbar.warning(Snackbar.make(getViewForLayoutAccess(), msg, Snackbar.LENGTH_SHORT)).show();
    }

    public void setInfoMsg(String msg){
        ColoredSnackbar.info(Snackbar.make(getViewForLayoutAccess(), msg, Snackbar.LENGTH_SHORT)).show();
    }

}
