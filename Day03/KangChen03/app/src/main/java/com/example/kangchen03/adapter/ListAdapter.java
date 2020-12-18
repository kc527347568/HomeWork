package com.example.kangchen03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kangchen03.R;
import com.example.kangchen03.bean.ItemBean;

import java.util.ArrayList;


public class ListAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<ItemBean.DataBean.ListBean> list;

    public ListAdapter(Context context, ArrayList<ItemBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        ItemBean.DataBean.ListBean listBean = list.get(position);
        viewHolder.tv_title.setText(listBean.getTitle());
        Glide.with(context).load(listBean.getFilePathList());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_title;
        public ImageView iv_filePath;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.iv_filePath = (ImageView) rootView.findViewById(R.id.iv_filePath);
        }

    }
}
