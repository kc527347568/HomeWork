package com.example.day02kczy.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day02kczy.R;
import com.example.day02kczy.bean.TuBean;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<TuBean.DataBeanX.DataBean> list;

    public HomeAdapter(Context context, ArrayList<TuBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view);
    }

    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        TuBean.DataBeanX.DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getCover()).into(viewHolder.iv_cover);
        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.iv_avatar);
        viewHolder.tv_feeds_text.setText(dataBean.getFeeds_text());
        viewHolder.tv_name.setText(dataBean.getAuthor().getName());
        viewHolder.tv_ok.setText(dataBean.getAuthor().getLikeCount()+"");
        viewHolder.tv_no.setText(dataBean.getAuthor().getFollowCount()+"");
        viewHolder.tv_shuo.setText(dataBean.getAuthor().getHistoryCount()+"");

        viewHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.OnClickListener(position);
            }
        });

    }

    public interface OnClick{
        void OnClickListener(int pos);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_avatar;
        public TextView tv_name;
        public TextView tv_feeds_text;
        public ImageView iv_cover;
        public TextView tv_ok;
        public LinearLayout ok;
        public TextView tv_no;
        public LinearLayout no;
        public TextView tv_shuo;
        public LinearLayout shuo;
        public TextView tv_fen;
        public LinearLayout fen;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_avatar = (ImageView) rootView.findViewById(R.id.iv_avatar);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_feeds_text = (TextView) rootView.findViewById(R.id.tv_feeds_text);
            this.iv_cover = (ImageView) rootView.findViewById(R.id.iv_cover);
            this.tv_ok = (TextView) rootView.findViewById(R.id.tv_ok);
            this.ok = (LinearLayout) rootView.findViewById(R.id.ok);
            this.tv_no = (TextView) rootView.findViewById(R.id.tv_no);
            this.no = (LinearLayout) rootView.findViewById(R.id.no);
            this.tv_shuo = (TextView) rootView.findViewById(R.id.tv_shuo);
            this.shuo = (LinearLayout) rootView.findViewById(R.id.shuo);
            this.tv_fen = (TextView) rootView.findViewById(R.id.tv_fen);
            this.fen = (LinearLayout) rootView.findViewById(R.id.fen);
        }

    }
}
