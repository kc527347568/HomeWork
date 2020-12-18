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
import com.umeng.lkx.bean.TushangBean;

import java.util.List;

public class TushangAdapter extends RecyclerView.Adapter<TushangAdapter.ViewHolder> {
    Context context;
    List<TushangBean.DataBean.ListBean> datas;
    int TYPE_ONE=1;
    int TYPE_TWO=2;
    public TushangAdapter(Context context, List<TushangBean.DataBean.ListBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==TYPE_ONE){
            View view = LayoutInflater.from(context).inflate(R.layout.recy1, parent, false);
            return new ViewHolder1(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.recy2, parent, false);
            return new ViewHolder2(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==1){
            return TYPE_ONE;
        }else {
            return TYPE_TWO;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type==TYPE_ONE){
            ViewHolder1 viewHolder1= (ViewHolder1) holder;
            viewHolder1.po.setText(datas.get(position).getTitle());
            Glide.with(context).load(datas.get(position).getFilePathList().get(0).getFilePath()).into(viewHolder1.tu);
        }else {
            ViewHolder2 viewHolder2= (ViewHolder2) holder;
            viewHolder2.tu1.setText(datas.get(position).getTitle());
            Glide.with(context).load(datas.get(position).getFilePathList().get(0).getFilePath()).into(viewHolder2.po1);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class ViewHolder1 extends ViewHolder {

        private final TextView po;
        private final ImageView tu;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            po = itemView.findViewById(R.id.po);
            tu = itemView.findViewById(R.id.tu);
        }
    }

    private class ViewHolder2 extends ViewHolder {

        private final ImageView po1;
        private final TextView tu1;

        public ViewHolder2(View view) {
            super(view);
            po1 = view.findViewById(R.id.po1);
            tu1 = view.findViewById(R.id.tu1);
        }
    }
}
