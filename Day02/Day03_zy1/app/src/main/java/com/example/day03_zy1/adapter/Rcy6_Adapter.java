package com.example.day03_zy1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03_zy1.R;
import com.example.day03_zy1.bean.TuiJian;

import java.util.ArrayList;
import java.util.List;

public
class Rcy6_Adapter extends RecyclerView.Adapter {

    private List<TuiJian.DataBeanX.DataBean> list;
    private Context context;

    public Rcy6_Adapter(List<TuiJian.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.rcy6_tuijian_item, parent, false );
        return new ViewHolder6( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder6 holder6 = (ViewHolder6) holder;
        TuiJian.DataBeanX.DataBean bean = list.get( position );
        holder6.mTvName.setText( bean.getTitle() );
        holder6.mTvDesc.setText( bean.getIntro() );
        Glide.with( context ).load( bean.getIcon() ).into( holder6.mLv );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder6 extends RecyclerView.ViewHolder {
        View view;
        ImageView mLv;
        TextView mTvName;
        TextView mTvDesc;
        Button mBut;

        ViewHolder6(View view) {
            super(view);
            this.view = view;
            this.mLv = (ImageView) view.findViewById( R.id.lv );
            this.mTvName = (TextView) view.findViewById( R.id.tv_name );
            this.mTvDesc = (TextView) view.findViewById( R.id.tv_desc );
            this.mBut = (Button) view.findViewById( R.id.but );
        }
    }
}
