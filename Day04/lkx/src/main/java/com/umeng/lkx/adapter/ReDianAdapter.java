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
import com.umeng.lkx.bean.ReDianBean;

import java.util.List;

public class ReDianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<ReDianBean.DataBean.ListBean> datas;
    int TYPE_ONE=1;
    int TYPE_TWO=2;
    int TYPE_THRE=3;

    public ReDianAdapter(Context context, List<ReDianBean.DataBean.ListBean> datas) {
        this.context = context;
        this.datas = datas;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==TYPE_ONE){
            View view = LayoutInflater.from(context).inflate(R.layout.re, parent, false);
            return new ViewHoder1(view);
        }else if (viewType==TYPE_TWO){
            View view = LayoutInflater.from(context).inflate(R.layout.rw, parent, false);
            return new ViewHolder2(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.rq, parent, false);
            return new ViewHolder3(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position%3==0){
            return TYPE_ONE;
        }else if (position%3==1){
            return TYPE_TWO;
        }else {
            return TYPE_THRE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type==TYPE_ONE){
            ViewHoder1 viewHoder1= (ViewHoder1) holder;
            viewHoder1.r1.setText(datas.get(position).getTitle());
            viewHoder1.r2.setText(datas.get(position).getCreateTime());
            Glide.with(context).load(datas.get(position).getFilePathList().get(0).getFilePath()).into(viewHoder1.ma);
            Glide.with(context).load(datas.get(position).getFilePathList().get(1).getFilePath()).into(viewHoder1.mb);
            Glide.with(context).load(datas.get(position).getFilePathList().get(2).getFilePath()).into(viewHoder1.mc);
        }else if (type==TYPE_TWO){
            ViewHolder2 viewHolder2= (ViewHolder2) holder;
            viewHolder2.lo.setText(datas.get(position).getTitle());
            Glide.with(context).load(datas.get(position).getFilePathList().get(0).getFilePath()).into(viewHolder2.mo);
        }else {
            ViewHolder3 viewHolder3= (ViewHolder3) holder;
            viewHolder3.lp.setText(datas.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private class ViewHoder1 extends RecyclerView.ViewHolder {

        private final TextView r1;
        private final TextView r2;
        private final ImageView ma;
        private final ImageView mb;
        private final ImageView mc;

        public ViewHoder1(@NonNull View itemView) {
            super(itemView);
            r1 = itemView.findViewById(R.id.r1);
            r2 = itemView.findViewById(R.id.r2);
            ma = itemView.findViewById(R.id.ma);
            mb = itemView.findViewById(R.id.mb);
            mc = itemView.findViewById(R.id.mc);
        }
    }

    private class ViewHolder2 extends RecyclerView.ViewHolder {

        private final TextView lo;
        private final ImageView mo;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            lo = itemView.findViewById(R.id.lo);
            mo = itemView.findViewById(R.id.mo);
        }
    }

    private class ViewHolder3 extends RecyclerView.ViewHolder {

        private final TextView lp;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            lp = itemView.findViewById(R.id.lp);
        }
    }
}
