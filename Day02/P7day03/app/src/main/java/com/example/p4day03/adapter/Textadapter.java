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
import com.example.p4day03.bean.Mp4bean;
import com.example.p4day03.bean.Textbean;

import java.util.ArrayList;

public class Textadapter extends RecyclerView.Adapter {

    private Context context;

    private ArrayList<Textbean.DataBeanX.DataBean> datas;
    private ImageView img_head_img;
    private TextView img_author;
    private TextView feeds_text;
    private ImageView img_bigimg;
    private TextView img_activitytext;
    private ImageView img_yes;
    private ImageView img_no;
    private ImageView img_shuo;
    private ImageView img_fen;


    public Textadapter(Context context, ArrayList<Textbean.DataBeanX.DataBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.text_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Textbean.DataBeanX.DataBean dataBean = datas.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        Textbean.DataBeanX.DataBean.AuthorBean author = dataBean.getAuthor();
        Glide.with(context).load(author.getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.text_img);
        viewHolder.text_name.setText(author.getName());
        viewHolder.comm.setText(author.getCommentCount()+"");
        viewHolder.like.setText(author.getLikeCount()+"");
        viewHolder.share.setText(author.getFavoriteCount()+"");

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView text_img;
        public TextView text_name;
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
            this.text_img = (ImageView) rootView.findViewById(R.id.text_img);
            this.text_name = (TextView) rootView.findViewById(R.id.text_name);
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
