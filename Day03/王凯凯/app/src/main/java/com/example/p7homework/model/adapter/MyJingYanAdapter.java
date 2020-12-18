package com.example.p7homework.model.adapter;

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
import com.example.p7homework.R;
import com.example.p7homework.model.bean.JingYanBean;

import java.util.List;

public class MyJingYanAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<JingYanBean.DataBean.ExpTopBean.ListBean> list;

    public MyJingYanAdapter(Context context, List<JingYanBean.DataBean.ExpTopBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jingyan_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        JingYanBean.DataBean.ExpTopBean.ListBean listBean = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.jingYan_item_name.setText(listBean.getNickName());
        viewHolder.jingYan_item_province.setText(listBean.getProvince());
        viewHolder.jingYan_item_city.setText(listBean.getCity());
        viewHolder.jingYan_item_tongQian.setText(listBean.getTongQian()+"");
        Glide.with(context).load(listBean.getHeadUrl()).apply(new RequestOptions().circleCrop()).into(viewHolder.jingYan_item_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends MyInfoAdapter.ViewHolder {
        public View rootView;
        public ImageView jingYan_item_image;
        public TextView jingYan_item_name;
        public TextView jingYan_item_province;
        public TextView jingYan_item_city;
        public TextView jingYan_item_tongQian;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.jingYan_item_image = (ImageView) rootView.findViewById(R.id.jingYan_item_image);
            this.jingYan_item_name = (TextView) rootView.findViewById(R.id.jingYan_item_name);
            this.jingYan_item_province = (TextView) rootView.findViewById(R.id.jingYan_item_province);
            this.jingYan_item_city = (TextView) rootView.findViewById(R.id.jingYan_item_city);
            this.jingYan_item_tongQian = (TextView) rootView.findViewById(R.id.jingYan_item_tongQian);
        }

    }
}
