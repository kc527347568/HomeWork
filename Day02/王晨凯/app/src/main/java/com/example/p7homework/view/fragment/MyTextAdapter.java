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
import com.example.p7homework.R;
import com.example.p7homework.model.bean.TextBean;

import java.util.List;

public class MyTextAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<TextBean.DataBeanX.DataBean> list;

    public MyTextAdapter(Context context, List<TextBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.text_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        TextBean.DataBeanX.DataBean dataBean = list.get(position);
        TextBean.DataBeanX.DataBean.AuthorBean author = dataBean.getAuthor();
        //头像
        Glide.with(context).load(author.getAvatar()).into(viewHolder.text_item_head);
        viewHolder.text_item_text.setText(author.getName());
        viewHolder.text_item_itemType1.setText(author.getLikeCount()+"");
        viewHolder.text_item_itemType2.setText(author.getCommentCount()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends MyInfoAdapter.ViewHolder {
        public View rootView;
        public ImageView text_item_head;
        public TextView text_item_text;
        public TextView text_item_itemType1;
        public TextView text_item_itemType2;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.text_item_head = (ImageView) rootView.findViewById(R.id.text_item_head);
            this.text_item_text = (TextView) rootView.findViewById(R.id.text_item_text);
            this.text_item_itemType1 = (TextView) rootView.findViewById(R.id.text_item_itemType1);
            this.text_item_itemType2 = (TextView) rootView.findViewById(R.id.text_item_itemType2);
        }

    }
}
