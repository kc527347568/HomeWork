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
import com.bumptech.glide.request.RequestOptions;
import com.umeng.lkx.R;
import com.umeng.lkx.bean.QianBean;

import java.util.List;

public class QianAdapter extends RecyclerView.Adapter<QianAdapter.ViewHolder> {
    Context context;
    List<QianBean.DataBean.SignTopBean.ListBean> dtaas;

    public QianAdapter(Context context, List<QianBean.DataBean.SignTopBean.ListBean> dtaas) {
        this.context = context;
        this.dtaas = dtaas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.qiandao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(dtaas.get(position).getHeadUrl()).apply(requestOptions).into(holder.w1);
        holder.k1.setText(dtaas.get(position).getNickName());
        holder.k2.setText(dtaas.get(position).getProvince());
        holder.k3.setText(dtaas.get(position).getCity());
        holder.k4.setText(dtaas.get(position).getLevel());
    }

    @Override
    public int getItemCount() {
        return dtaas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView w1;
        private final TextView k1;
        private final TextView k2;
        private final TextView k3;
        private final TextView k4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            w1 = itemView.findViewById(R.id.w1);
            k1 = itemView.findViewById(R.id.k1);
            k2 = itemView.findViewById(R.id.k2);
            k3 = itemView.findViewById(R.id.k3);
            k4 = itemView.findViewById(R.id.k4);
        }
    }
}
