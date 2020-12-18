package com.example.day03_zy1.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03_zy1.R;
import com.example.day03_zy1.bean.SPBean;

import java.util.List;

import retrofit2.http.GET;

public
class Rcy2_Adapter extends RecyclerView.Adapter {
    private List<SPBean.DataBeanX.DataBean> list;
    private Context context;

    public Rcy2_Adapter(List<SPBean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.rcy2_item_sp, parent, false );
        return new ViewHolder2( view );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder2 holder2 = (ViewHolder2) holder;
        SPBean.DataBeanX.DataBean bean = list.get( position );
        SPBean.DataBeanX.DataBean.AuthorBean author = bean.getAuthor();
        holder2.tv.setText( author.getName() );
        Glide.with( context ).load( author.getAvatar() ).into( holder2.head );
        holder2.vv.setMediaController( new MediaController( context ) );
        holder2.vv.setVideoPath( bean.getUrl() );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView head;
        public TextView tv;
        public VideoView vv;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.head = (ImageView) rootView.findViewById( R.id.head );
            this.tv = (TextView) rootView.findViewById( R.id.tv );
            this.vv = (VideoView) rootView.findViewById( R.id.vv );
        }

    }
}
