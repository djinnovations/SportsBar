package com.sportsbar.main.adapters;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import dj.sportsbar.main.R;
import com.sportsbar.main.activities.MyApplication;
import com.sportsbar.main.model.CheckboxTitlesData;
import com.sportsbar.main.model.ThumbnailData;
import com.sportsbar.main.uiutils.DisplayProperties;

/**
 * Created by User on 07-02-2017.
 */

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.ViewHolder> implements GenericAdapterInterface{

    protected MyApplication.MenuSelectionListener listener;
    private List<ThumbnailData> dataList = new ArrayList<>();

    public ThumbnailAdapter(MyApplication.MenuSelectionListener listener){
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getRootLayout(), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ThumbnailData data = (ThumbnailData) getItem(position);
        if (TextUtils.isEmpty(data.getUrl())){
            int width = (int) (25 * DisplayProperties.getInstance(DisplayProperties.ORIENTATION_PORTRAIT)
                    .getXPixelsPerCell());
            Picasso.with(holder.itemView.getContext())
                    .load(data.getUrl())/*.memoryPolicy(MemoryPolicy.NO_STORE, MemoryPolicy.NO_CACHE)*/
                    .placeholder(R.drawable.img_temp_thumbnail_small)
                    .error(R.drawable.img_temp_thumbnail_small)
                    .resize(width, 0)
                    .into(holder.ivThumbnail);
        }else
            Picasso.with(holder.itemView.getContext()).load(R.drawable.img_temp_thumbnail_small).into(holder.ivThumbnail);
        if(TextUtils.isEmpty(data.getTitle()))
            holder.tvTitle.setVisibility(View.GONE);
        else holder.tvTitle.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void changeData(List dataList) throws Exception {
        if (dataList == null || dataList.size() <= 0)
            return;
        if (!(dataList.get(0) instanceof CheckboxTitlesData))
            throw new IllegalArgumentException("Required data type \"ThumbnailData\"");
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
        return R.layout.adapter_thumbnail_new;
    }

    protected Object getItem(int position){
        return dataList.get(position);
    }

    @Override
    public void setOnClickListener(RecyclerView.ViewHolder holder) {
        holder.itemView.setOnClickListener((View.OnClickListener) holder);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.ivThumbnail)
        ImageView ivThumbnail;
        @Bind(R.id.tvTitle)
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onMenuSelected(getItem(getAdapterPosition()));
        }
    }
}
