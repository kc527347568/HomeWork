package com.example.day03zuoye.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03zuoye.R;
import com.example.day03zuoye.bean.Remenhuodong;

import java.util.ArrayList;

public class Remenhuodongrecadapter extends RecyclerView.Adapter {

    private Context context;

    private ArrayList<Remenhuodong.DataBean> remen;

    public Remenhuodongrecadapter(Context context, ArrayList<Remenhuodong.DataBean> remen) {
        this.context = context;
        this.remen = remen;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.remen_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Remenhuodong.DataBean dataBean = remen.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(dataBean.getCover()).into(viewHolder.remen_img);
        viewHolder.remen_tv.setText(dataBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return remen.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView remen_img;
        public TextView remen_tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.remen_img = (ImageView) rootView.findViewById(R.id.remen_img);
            this.remen_tv = (TextView) rootView.findViewById(R.id.remen_tv);
        }

    }
}
