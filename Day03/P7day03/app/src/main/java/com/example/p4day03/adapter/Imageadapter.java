package com.example.p4day03.adapter;

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
import com.example.p4day03.R;
import com.example.p4day03.bean.Imagebean;

import java.util.ArrayList;

public class Imageadapter extends RecyclerView.Adapter {

    private Context context;

    private ArrayList<Imagebean.DataBeanX.DataBean> datas;
    private ImageView img_head_img;
    private TextView img_author;
    private TextView feeds_text;
    private ImageView img_bigimg;
    private TextView img_activitytext;
    private ImageView img_yes;
    private ImageView img_no;
    private ImageView img_shuo;
    private ImageView img_fen;


    public Imageadapter(Context context, ArrayList<Imagebean.DataBeanX.DataBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Imagebean.DataBeanX.DataBean dataBean = datas.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.feeds_text.setText(dataBean.getFeeds_text());
        Glide.with(context).load(dataBean.getCover()).into(viewHolder.img_bigimg);
        Imagebean.DataBeanX.DataBean.AuthorBean author = dataBean.getAuthor();
        Glide.with(context).load(author.getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.img_head_img);
        viewHolder.img_author.setText(author.getName());
        viewHolder.img_activitytext.setText(dataBean.getActivityText());
        viewHolder.like.setText(author.getLikeCount()+"");
        viewHolder.comm.setText(author.getCommentCount()+"");
        viewHolder.share.setText(author.getFavoriteCount()+"");

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img_head_img;
        public TextView img_author;
        public TextView feeds_text;
        public ImageView img_bigimg;
        public TextView img_activitytext;
        public ImageView img_yes;
        public TextView like;
        public ImageView img_no;
        public ImageView img_shuo;
        public TextView comm;
        public ImageView img_fen;
        public TextView share;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_head_img = (ImageView) rootView.findViewById(R.id.img_head_img);
            this.img_author = (TextView) rootView.findViewById(R.id.img_author);
            this.feeds_text = (TextView) rootView.findViewById(R.id.feeds_text);
            this.img_bigimg = (ImageView) rootView.findViewById(R.id.img_bigimg);
            this.img_activitytext = (TextView) rootView.findViewById(R.id.img_activitytext);
            this.img_yes = (ImageView) rootView.findViewById(R.id.img_yes);
            this.like = (TextView) rootView.findViewById(R.id.like);
            this.img_no = (ImageView) rootView.findViewById(R.id.img_no);
            this.img_shuo = (ImageView) rootView.findViewById(R.id.img_shuo);
            this.comm = (TextView) rootView.findViewById(R.id.comm);
            this.img_fen = (ImageView) rootView.findViewById(R.id.img_fen);
            this.share = (TextView) rootView.findViewById(R.id.share);
        }

    }
}
