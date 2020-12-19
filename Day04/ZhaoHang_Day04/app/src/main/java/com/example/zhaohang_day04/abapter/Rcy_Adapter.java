package com.example.zhaohang_day04.abapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zhaohang_day04.R;
import com.example.zhaohang_day04.bean.HuoDongBean;

import java.util.List;

public
class Rcy_Adapter extends RecyclerView.Adapter {
    private List<HuoDongBean.DataBean> list;
    private Context context;
    private LayoutInflater from;
    private ImageView lv;
    private TextView tv;

    public Rcy_Adapter(List<HuoDongBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //    final static int TYPE_1 = 0;
//    @Override
//    public int getItemViewType(int position) {
//        if (p)
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        from = LayoutInflater.from( context );
        View view = from.inflate( R.layout.rcy_item1, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        HuoDongBean.DataBean dataBean = list.get( position );
        Glide.with( context ).load( dataBean.getCover() ).into( holder1.lv );
        Log.e( "GTR",dataBean.getLeader() );
//        tv.setText( dataBean.getApplyCutOffTime() );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView lv;
        public TextView tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.lv = (ImageView) rootView.findViewById( R.id.lv );
            this.tv = (TextView) rootView.findViewById( R.id.tv );
        }

    }
}
