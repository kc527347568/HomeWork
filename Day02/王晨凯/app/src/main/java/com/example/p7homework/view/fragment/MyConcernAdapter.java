package com.example.p7homework.view.fragment;

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
import com.example.p7homework.R;

import java.util.List;

//public class MyConcernAdapter extends RecyclerView.Adapter {
//    private Context context;
//    private List<ConcernBean> list;
//
//    public MyConcernAdapter(Context context, List<ConcernBean> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.concern_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        ViewHolder viewHolder = (ViewHolder) holder;
//        ConcernBean concernBean = list.get(position);
//        Glide.with(context).load(concernBean.getImagePath()).into(viewHolder.concern_item_image);
//        viewHolder.concern_item_title.setText(concernBean.getTitle());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    public static
//    class ViewHolder extends MyRecoAdapter.ViewHolder {
//        public View rootView;
//        public ImageView concern_item_image;
//        public TextView concern_item_title;
//        public Button concern_item_but;
//
//        public ViewHolder(View rootView) {
//            super(rootView);
//            this.rootView = rootView;
//            this.concern_item_image = (ImageView) rootView.findViewById(R.id.concern_item_image);
//            this.concern_item_title = (TextView) rootView.findViewById(R.id.concern_item_title);
//            this.concern_item_but = (Button) rootView.findViewById(R.id.concern_item_but);
//        }
//
//    }
//}
