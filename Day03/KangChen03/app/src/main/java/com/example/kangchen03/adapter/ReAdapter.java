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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.kangchen03.R;
import com.example.kangchen03.bean.ReMengBean;

import java.util.ArrayList;

public class ReAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<ReMengBean.DataBean> list;

    public ReAdapter(Context context, ArrayList<ReMengBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_re, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        ReMengBean.DataBean dataBean = list.get(position);
        viewHolder.tv_title.setText(dataBean.getTitle());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.transform(new RoundedCorners(60));
        Glide.with(context).load(dataBean.getCover()).apply(requestOptions).into(viewHolder.iv_cover);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_cover;
        public TextView tv_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_cover = (ImageView) rootView.findViewById(R.id.iv_cover);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        }

    }
}
