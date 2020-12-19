package com.example.day04.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day04.R;
import com.example.day04.model.bean.HotBean;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ItemOneAdapter extends RecyclerView.Adapter {
    private List<HotBean.DataBean> list;
    private Context context;

    public ItemOneAdapter(List<HotBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=null;
        if (viewType==0){
            TabLayout tab=view.findViewById(R.id.tab);
            //tab.set
        }
        //View view = LayoutInflater.from(context).inflate(R.layout.layout_item1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public RecyclerView rel;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rel = (RecyclerView) rootView.findViewById(R.id.rel);
        }

    }
}
