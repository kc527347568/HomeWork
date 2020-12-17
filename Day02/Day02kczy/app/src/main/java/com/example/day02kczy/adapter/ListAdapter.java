package com.example.day02kczy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day02kczy.R;
import com.example.day02kczy.bean.DataBean;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<DataBean> list;

    public ListAdapter(Context context, ArrayList<DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    private OnChecked onChecked;

    public void setOnChecked(OnChecked onChecked) {
        this.onChecked = onChecked;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DataBean dataBean = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tv_intro.setText(dataBean.getIntro());
        viewHolder.tv_title.setText(dataBean.getTitle());
        viewHolder.but_ok.setChecked(dataBean.getHasFollow());
//        if (dataBean.getHasFollow()){
//            viewHolder.but_ok.setText("已关注");
//        }else {
//            viewHolder.but_ok.setText("关注");
//        }
        Glide.with(context).load(dataBean.getIcon()).into(viewHolder.iv_icon);

        viewHolder.but_ok.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.get(position).setHasFollow(isChecked);
                if (buttonView.isPressed()){
                    if (isChecked) {
                        viewHolder.but_ok.setText("已关注");
                        onChecked.CheckedListener(position);

                    }else {
                        viewHolder.but_ok.setText("关注");
                        onChecked.CheckedListener(position);
                    }
                }
            }
        });

    }

    public interface OnChecked{
        void CheckedListener(int pos);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_icon;
        public TextView tv_title;
        public TextView tv_intro;
        public CheckBox but_ok;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_icon = (ImageView) rootView.findViewById(R.id.iv_icon);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_intro = (TextView) rootView.findViewById(R.id.tv_intro);
            this.but_ok = (CheckBox) rootView.findViewById(R.id.but_ok);
        }

    }
}
