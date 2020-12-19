package com.example.p7homework.view.fragment;

import android.content.Context;
import android.util.Log;
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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.p7homework.R;
import com.example.p7homework.model.bean.DataBean;

import java.util.List;

public class MyRecoAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<DataBean> list;
    private ItemListener listener;

    public ItemListener getListener() {
        return listener;
    }

    public void setListener(ItemListener listener) {
        this.listener = listener;
    }

    public MyRecoAdapter(Context context, List<DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reco_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       ViewHolder viewHolder = (ViewHolder) holder;
        DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getIcon()).apply(new RequestOptions().transform(new RoundedCorners(30))).into(viewHolder.reco_item_image);
        viewHolder.reco_item_title.setText(dataBean.getTitle());
        viewHolder.reco_item_but.setClickable(dataBean.isHasFollow());

        viewHolder.reco_item_but.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.e("TAG","123"+list.get(position).getHasFollow());
                if (compoundButton.isPressed()) {
                    if (!list.get(position).getHasFollow()) {
                        viewHolder.reco_item_but.setText("已关注");
                        listener.itemClick(position);
                        Log.e("TAG","取消"+1);

                    } else {
                        viewHolder.reco_item_but.setText("关注");
                        listener.itemClick(position);
                        Log.e("TAG","关注"+2);

                    }
                }
                Log.e("TAG","231"+list.get(position).getHasFollow());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface ItemListener {
        void itemClick(int p);
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView reco_item_image;
        public TextView reco_item_title;
        public CheckBox reco_item_but;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.reco_item_image = (ImageView) rootView.findViewById(R.id.reco_item_image);
            this.reco_item_title = (TextView) rootView.findViewById(R.id.reco_item_title);
            this.reco_item_but = (CheckBox) rootView.findViewById(R.id.reco_item_but);
        }

    }
}
