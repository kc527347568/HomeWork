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
import com.umeng.lkx.bean.SheTuanBean;

import java.util.List;

public class SheTuanAdapter extends RecyclerView.Adapter<SheTuanAdapter.ViewHolder> {
    Context context;
    List<SheTuanBean.DataBean> datas;

    public SheTuanAdapter(Context context, List<SheTuanBean.DataBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.she, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(datas.get(position).getLogo()).into(holder.she1);
        holder.z1.setText(datas.get(position).getProvince());
        holder.z2.setText(datas.get(position).getFullName());
        holder.z3.setText(datas.get(position).getNote());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView she1;
        private final TextView z1;
        private final TextView z2;
        private final TextView z3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            she1 = itemView.findViewById(R.id.she1);
            z1 = itemView.findViewById(R.id.z1);
            z2 = itemView.findViewById(R.id.z2);
            z3 = itemView.findViewById(R.id.z3);
        }
    }
}
