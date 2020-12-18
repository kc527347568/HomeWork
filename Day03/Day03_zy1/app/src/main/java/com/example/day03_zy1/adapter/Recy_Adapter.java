package com.example.day03_zy1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day03_zy1.R;
import com.example.day03_zy1.bean.ImageBean;
import com.example.day03_zy1.fragmen.nestfragmen.BlankFragment1;

import java.util.ArrayList;
import java.util.List;

public
class Recy_Adapter extends RecyclerView.Adapter {
    private List<ImageBean.DataBeanX.DataBean> list;
    private Context context;

    public Recy_Adapter(List<ImageBean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.rcy_image_item, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        ImageBean.DataBeanX.DataBean dataBean = list.get( position );
        ImageBean.DataBeanX.DataBean.AuthorBean author = list.get( position ).getAuthor();
        holder1.mTv.setText( author.getName() );
        Glide.with( context ).load( author.getAvatar() ).apply( new RequestOptions().circleCrop() ).into( holder1.mHead );
        Glide.with( context ).load( dataBean.getCover() ).into( holder1.mVv );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        ImageView mHead;
        TextView mTv;
        ImageView mVv;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            this.mHead = (ImageView) view.findViewById( R.id.head );
            this.mTv = (TextView) view.findViewById( R.id.tv );
            this.mVv = (ImageView) view.findViewById( R.id.vv );
        }
    }
}
