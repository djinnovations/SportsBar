package com.sportsbar.main.adapters;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.sportsbar.main.model.CheckboxTitlesData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import dj.sportsbar.main.R;
import com.sportsbar.main.activities.MyApplication;

/**
 * Created by User on 26-01-2017.
 */

public class CheckboxTitleAdapter extends RecyclerView.Adapter<CheckboxTitleAdapter.ViewHolder> implements GenericAdapterInterface{

    protected List<CheckboxTitlesData> dataList = new ArrayList<>();
    private CheckboxTitlesData previousSelection;
    protected MyApplication.MenuSelectionListener listener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getRootLayout(), parent, false);
        return new ViewHolder(view);
    }

    public CheckboxTitleAdapter(MyApplication.MenuSelectionListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CheckboxTitlesData data = dataList.get(position);
        if (data.isSelected()){
            previousSelection = data;
            holder.checkBox.setChecked(true);
        }else holder.checkBox.setChecked(false);
        holder.tvItem.setText(data.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void changeData(List dataList) throws IllegalArgumentException{
        if (dataList == null || dataList.size() <= 0)
            return;
        if (!(dataList.get(0) instanceof CheckboxTitlesData))
            throw new IllegalArgumentException("Required data type \"CheckboxTitlesData\"");
        this.dataList.clear();
        this.dataList.addAll(dataList);
        (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        }, 100);
    }

    @Override
    public int getRootLayout() {
        return R.layout.adapter_title_checkbox;
    }

    @Override
    public void setOnClickListener(RecyclerView.ViewHolder holder) {
        holder.itemView.setOnClickListener((View.OnClickListener) holder);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.tvItem)
        TextView tvItem;
        @Bind(R.id.checkbox)
        CheckBox checkBox;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final int pos = dataList.indexOf(previousSelection);
            if (pos == getAdapterPosition())
                return;
            if (listener != null)
                listener.onMenuSelected(dataList.get(getAdapterPosition()));
            CheckboxTitlesData data = dataList.get(getAdapterPosition());
            data.setSelected(true);
            dataList.set(getAdapterPosition(), data);
            if (pos != -1) {
                previousSelection.setSelected(false);
                dataList.set(pos, previousSelection);
            }
            (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {
                @Override
                public void run() {
                    notifyDataSetChanged();
                }
            }, 100);
        }
    }

}
