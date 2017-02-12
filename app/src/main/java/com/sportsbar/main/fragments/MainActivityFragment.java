package com.sportsbar.main.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sportsbar.main.adapters.ThumbnailAdapter;

import java.util.List;

import com.sportsbar.main.activities.MyApplication;
import com.sportsbar.main.model.ThumbnailData;

/**
 * Created by User on 06-02-2017.
 */

public class MainActivityFragment extends SingleMenuFragment{

    ThumbnailAdapter adapter;

    @Override
    public boolean isAddSnapper() {
        return false;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    @Override
    public void changeData(List dataList) {
        try {
            adapter.changeData(dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        MyApplication.MenuSelectionListener listener = new MyApplication.MenuSelectionListener() {
            @Override
            public void onMenuSelected(Object data) {
                updateView((ThumbnailData) data);
            }
        };
        adapter = new ThumbnailAdapter(listener);
        super.onViewCreated(view, savedInstanceState);
        /*if (getActivity() instanceof AwignQuestionsActivity){
            menuAdapter.changeData(((AwignQuestionsActivity) getActivity()).getData());
        }*/
    }

    protected void updateView(ThumbnailData data) {

    }

}
