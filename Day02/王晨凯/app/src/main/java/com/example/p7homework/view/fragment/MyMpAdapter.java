package com.example.p7homework.view.fragment;

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
import com.example.p7homework.model.bean.MpBean;

import java.util.List;

import cn.jzvd.JzvdStd;

public class MyMpAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MpBean.DataBeanX.DataBean> list;

    public MyMpAdapter(Context context, List<MpBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mp_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        MpBean.DataBeanX.DataBean dataBean = list.get(position);
        MpBean.DataBeanX.DataBean.AuthorBean author = dataBean.getAuthor();
        //头像
        Glide.with(context).load(author.getAvatar()).apply(new RequestOptions().circleCrop())
                .into(viewHolder.mp_item_head);
        viewHolder.mp_item_text.setText(dataBean.getFeeds_text());

        viewHolder.mp_item_name.setText(author.getName());
// 视频
        JzvdStd mp_item_mp = viewHolder.mp_item_Mp;
        mp_item_mp.setUp(dataBean.getUrl(), "视频");
        mp_item_mp.startVideo();

        viewHolder.mp_item_itemType1.setText(author.getLikeCount() + "");
        viewHolder.mp_item_itemType2.setText(author.getCommentCount() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static
    class ViewHolder extends MyInfoAdapter.ViewHolder {
        public View rootView;
        public ImageView mp_item_head;
        public TextView mp_item_text;
        public JzvdStd mp_item_Mp;
        public TextView mp_item_itemType1;
        public TextView mp_item_itemType2;
        public TextView mp_item_name;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mp_item_head = (ImageView) rootView.findViewById(R.id.mp_item_head);
            this.mp_item_text = (TextView) rootView.findViewById(R.id.mp_item_text);
            this.mp_item_Mp = (JzvdStd) rootView.findViewById(R.id.mp_item_Mp);
            this.mp_item_itemType1 = (TextView) rootView.findViewById(R.id.mp_item_itemType1);
            this.mp_item_itemType2 = (TextView) rootView.findViewById(R.id.mp_item_itemType2);
            this.mp_item_name = (TextView) rootView.findViewById(R.id.mp_item_name);
        }

    }
}
