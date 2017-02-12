package com.sportsbar.main.adapters;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by User on 26-01-2017.
 */

public interface GenericAdapterInterface {
    void changeData(List dataList) throws Exception;
    int getRootLayout();
    void setOnClickListener(RecyclerView.ViewHolder holder);
}
