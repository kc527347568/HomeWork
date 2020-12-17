package com.example.day03_zy1.adapter;

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
import com.example.day03_zy1.R;
import com.example.day03_zy1.bean.TextBean;

import java.util.List;

public
class Recy_Adapter3 extends RecyclerView.Adapter {
    private List<TextBean.DataBeanX.DataBean> list;
    private Context context;

    public Recy_Adapter3(List<TextBean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.rcy3_text_item, parent, false );
        return new ViewHolder3( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder3 holder3 = (ViewHolder3) holder;
        TextBean.DataBeanX.DataBean bean = list.get( position );
        TextBean.DataBeanX.DataBean.AuthorBean author = bean.getAuthor();
        holder3.mTv.setText( author.getName() );
        holder3.mTvDa.setText( author.getName() );
        Glide.with( context ).load( author.getAvatar() ).apply( new RequestOptions().circleCrop() ).into( holder3.mHead );

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static
    class ViewHolder3 extends RecyclerView.ViewHolder {
        View view;
        ImageView mHead;
        TextView mTv;
        TextView mTvDa;

        ViewHolder3(View view) {
            super(view);
            this.view = view;
            this.mHead = (ImageView) view.findViewById( R.id.head );
            this.mTv = (TextView) view.findViewById( R.id.tv );
            this.mTvDa = (TextView) view.findViewById( R.id.tv_da );
        }
    }
}
