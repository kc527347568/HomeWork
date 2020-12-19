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
import com.example.day03zuoye.bean.Redianbean;

import java.util.ArrayList;

public class Qianadapter extends RecyclerView.Adapter {

    private Context context;

    private ArrayList<Redianbean.DataBean.ListBean> datas;

    public Qianadapter(Context context, ArrayList<Redianbean.DataBean.ListBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.qian_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Redianbean.DataBean.ListBean listBean = datas.get(position);
        Glide.with(context).load(listBean.getFilePathList()).into(viewHolder.qian_img);
        viewHolder.qian_tv.setText(listBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView qian_tv;
        public ImageView qian_img;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.qian_tv = (TextView) rootView.findViewById(R.id.qian_tv);
            this.qian_img = (ImageView) rootView.findViewById(R.id.qian_img);
        }

    }
}
