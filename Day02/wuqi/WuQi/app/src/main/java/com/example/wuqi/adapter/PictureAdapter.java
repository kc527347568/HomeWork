package com.example.wuqi.adapter;

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
import com.example.wuqi.R;
import com.example.wuqi.model.bean.PictureBean;

import java.util.ArrayList;
import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter {
    private List<PictureBean.DataBeanX.DataBean> list;
    private Context context;

    public PictureAdapter(List<PictureBean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_image, parent, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ImageHolder imageHolder= (ImageHolder) holder;
        imageHolder.tv_title.setText(list.get(position).getAuthor().getName());
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop())
        .into(imageHolder.iv_pic);
        Glide.with(context).load(list.get(position).getCover()).into(imageHolder.iv_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ImageHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_pic;
        public TextView tv_title;
        public ImageView iv_img;

        public ImageHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_pic = (ImageView) rootView.findViewById(R.id.iv_pic);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
        }

    }
}
