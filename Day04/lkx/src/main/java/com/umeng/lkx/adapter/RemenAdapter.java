package com.umeng.lkx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.umeng.lkx.R;
import com.umeng.lkx.bean.RemenBean;

import java.util.List;

public class RemenAdapter extends RecyclerView.Adapter<RemenAdapter.ViewHolder> {
    Context context;
    List<RemenBean.DataBean> datas;

    public RemenAdapter(Context context, List<RemenBean.DataBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.remen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(datas.get(position).getImageUrl()).into(holder.m1);
        holder.t1.setText(datas.get(position).getName());
        holder.t2.setText(datas.get(position).getDepict());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView m1;
        private final TextView t1;
        private final TextView t2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            m1 = itemView.findViewById(R.id.m1);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
        }
    }
}
