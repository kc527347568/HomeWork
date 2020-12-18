package com.example.day04.adapter;

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
import com.example.day04.R;
import com.example.day04.model.bean.ExperienceBean;

import java.util.List;

public class ExperienceAdapter extends RecyclerView.Adapter {
    private List<ExperienceBean.DataBean.ExpTopBean.ListBean> list;
    private Context context;

    public ExperienceAdapter(List<ExperienceBean.DataBean.ExpTopBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_experience, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.tv_title.setText(list.get(position).getNickName());
        viewHolder.tv_experience.setText(list.get(position).getExpScore()+"经验");
        Glide.with(context).load(list.get(position).getHeadUrl()).
                apply(new RequestOptions().circleCrop()).into(viewHolder.iv_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_img;
        public TextView tv_title;
        public TextView tv_experience;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_experience = (TextView) rootView.findViewById(R.id.tv_experience);
        }

    }
}
