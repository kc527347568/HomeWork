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
import com.example.wuqi.model.bean.TextBean;

import java.util.List;

import javax.crypto.spec.IvParameterSpec;

public class TextAdapter extends RecyclerView.Adapter {
    private List<TextBean.DataBeanX.DataBean> list;
    private Context context;

    public TextAdapter(List<TextBean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_text, parent, false);
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextHolder textHolder= (TextHolder) holder;
        textHolder.tv_title.setText(list.get(position).getAuthor().getName());
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(textHolder.iv_pic);
        //textHolder.tv_ping.setText(list.get(position).getActivityText().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class TextHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_pic;
        public TextView tv_title;
        public TextView tv_ping;

        public TextHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_pic = (ImageView) rootView.findViewById(R.id.iv_pic);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_ping = (TextView) rootView.findViewById(R.id.tv_ping);
        }

    }
}
