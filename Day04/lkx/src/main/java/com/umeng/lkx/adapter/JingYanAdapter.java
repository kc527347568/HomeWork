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
import com.umeng.lkx.bean.JingYanBean;

import java.util.List;

public class JingYanAdapter extends RecyclerView.Adapter<JingYanAdapter.ViewHolder> {
    Context context;
    List<JingYanBean.DataBean.ExpTopBean.ListBean> datas;

    public JingYanAdapter(Context context, List<JingYanBean.DataBean.ExpTopBean.ListBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.j, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(datas.get(position).getHeadUrl()).apply(requestOptions).into(holder.j1);
        holder.y1.setText(datas.get(position).getNickName());
        holder.y2.setText(datas.get(position).getProvince());
        holder.y3.setText(datas.get(position).getCity());
        holder.y4.setText(datas.get(position).getNickName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView j1;
        private final TextView y1;
        private final TextView y2;
        private final TextView y3;
        private final TextView y4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            j1 = itemView.findViewById(R.id.j1);
            y1 = itemView.findViewById(R.id.y1);
            y2 = itemView.findViewById(R.id.y2);
            y3 = itemView.findViewById(R.id.y3);
            y4 = itemView.findViewById(R.id.y4);
        }
    }
}
