package com.example.wuqi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.wuqi.R;
import com.example.wuqi.model.bean.RecommendBean;

import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter {
    private List<RecommendBean.DataBeanX.DataBean> list;
    private Context context;

    public RecommendAdapter(List<RecommendBean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_recommend, parent, false);
        return new RecommendHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        RecommendHolder recommendHolder= (RecommendHolder) holder;
        recommendHolder.tv_title.setText(list.get(position).getTitle());
        recommendHolder.tv_content.setText(list.get(position).getIntro());
        Glide.with(context).load(list.get(position).getIcon())
                .apply(new RequestOptions().transform(new RoundedCorners(15))).into(recommendHolder.iv_icon);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick!=null){
                    onItemClick.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class RecommendHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_icon;
        public TextView tv_title;
        public TextView tv_content;

        public RecommendHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_icon = (ImageView) rootView.findViewById(R.id.iv_icon);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_content=(TextView) rootView.findViewById(R.id.tv_content);
        }

    }
    public interface OnItemClick{
        void onItemClick(int position);
    }
    private OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
