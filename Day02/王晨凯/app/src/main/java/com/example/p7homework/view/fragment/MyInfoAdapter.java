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
import com.example.p7homework.model.bean.ImageBean;

import java.util.List;

public class MyInfoAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ImageBean.Data.DataBean> list;

    public MyInfoAdapter(Context context, List<ImageBean.Data.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        ImageBean.Data.DataBean dataBean = list.get(position);
        //头像
        ImageBean.Data.DataBean.AuthorBean author = dataBean.getAuthor();
        Glide.with(context).load(author.getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.image_item_head);
        //
        viewHolder.image_item_name.setText(author.getName());
        //
        viewHolder.image_item_text.setText(dataBean.getFeeds_text());
        Glide.with(context).load(dataBean.getCover()).into(viewHolder.image_item_image);
        viewHolder.image_item_activityText.setText(dataBean.getActivityText());
        viewHolder.image_item_itemType1.setText(author.getLikeCount()+ "");
        viewHolder.image_item_itemType2.setText(author.getHistoryCount()+ "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image_item_head;
        public TextView image_item_text;
        public ImageView image_item_image;
        public TextView image_item_activityText;
        public TextView image_item_itemType1;
        public TextView image_item_itemType2;
        public TextView image_item_name;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_item_head = (ImageView) rootView.findViewById(R.id.image_item_head);
            this.image_item_text = (TextView) rootView.findViewById(R.id.image_item_text);
            this.image_item_image = (ImageView) rootView.findViewById(R.id.image_item_image);
            this.image_item_activityText = (TextView) rootView.findViewById(R.id.image_item_activityText);
            this.image_item_itemType1 = (TextView) rootView.findViewById(R.id.image_item_itemType1);
            this.image_item_itemType2 = (TextView) rootView.findViewById(R.id.image_item_itemType2);
            this.image_item_name = (TextView) rootView.findViewById(R.id.image_item_name);
        }

    }
}
