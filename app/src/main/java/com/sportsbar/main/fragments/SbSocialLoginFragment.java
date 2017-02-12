package com.sportsbar.main.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dj.sportsbar.main.R;
import com.sportsbar.main.utils.RandomUtils;

/**
 * Created by User on 25-01-2017.
 */

public class SbSocialLoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_social_sb, container, false);
    }

    @Bind(R.id.ivFb)
    ImageView btnFbLogin;
    @Bind(R.id.ivGl)
    ImageView btnGoogleLogin;
    @Bind(R.id.ivPh)
    ImageView ivPhLogin;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        randomUtils = RandomUtils.getInstance();
        setUpIcons();
    }

    RandomUtils randomUtils;

    private void setUpIcons() {
        randomUtils.changeDrawable(btnFbLogin, FontAwesome.Icon.faw_facebook, R.color.colorGreyDim);
        randomUtils.changeDrawable(btnGoogleLogin, FontAwesome.Icon.faw_google, R.color.colorGreyDim);
        randomUtils.changeDrawable(ivPhLogin, FontAwesome.Icon.faw_android, R.color.colorGreyDim);
    }


    @OnClick(R.id.ivGl)
    void performGlLogin() {
        /*if (getActivity() instanceof AwignLoginActivity){
            ((AwignLoginActivity) getActivity()).getmSocialLoginInstance().onGoogleLogin(getActivity());
        }*/
    }

    @OnClick(R.id.ivPh)
    void launchNormalLoginScreen() {
        //RandomUtils.getInstance().launchNormalSignIn(getActivity());
    }

    @OnClick(R.id.ivFb)
    void performFbLogin() {
        //RandomUtils.getInstance().launchNormalSignIn(getActivity());
    }
}
