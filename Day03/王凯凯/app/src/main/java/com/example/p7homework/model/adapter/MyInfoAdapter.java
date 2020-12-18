package com.example.p7homework.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.p7homework.R;
import com.example.p7homework.model.bean.ListBean;

import java.util.List;


public class MyInfoAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ListBean.DataBean> list;

    public MyInfoAdapter(Context context, List<ListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ry_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListBean.DataBean dataBean = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.ry_item_title.setText(dataBean.getTitle());
        viewHolder.ry_item_location.setText(dataBean.getLocation());
        viewHolder.ry_item_applyCutOffTime.setText(dataBean.getApplyCutOffTime());
        Glide.with(context).load(dataBean.getCover()).into(viewHolder.ry_item_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView ry_item_image;
        public TextView ry_item_title;
        public TextView ry_item_location;
        public TextView ry_item_applyCutOffTime;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.ry_item_image = (ImageView) rootView.findViewById(R.id.ry_item_image);
            this.ry_item_title = (TextView) rootView.findViewById(R.id.ry_item_title);
            this.ry_item_location = (TextView) rootView.findViewById(R.id.ry_item_location);
            this.ry_item_applyCutOffTime = (TextView) rootView.findViewById(R.id.ry_item_applyCutOffTime);
        }

    }
}
