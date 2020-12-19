package com.example.day03zuoye.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.day03zuoye.R;
import com.example.day03zuoye.bean.Fenleitab;
import com.example.day03zuoye.bean.Remenhuodong;
import com.example.day03zuoye.fragment.RedianFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Faxianrecadapter extends RecyclerView.Adapter {

    private Context context;

    private ArrayList<Remenhuodong.DataBean> remen;

    private ArrayList<Fenleitab.DataBean> fentab;
    private final FragmentManager supportFragmentManager;
    private Vpadapter vpadapter;

    public Faxianrecadapter(Context context, ArrayList<Remenhuodong.DataBean> remen, ArrayList<Fenleitab.DataBean> fentab, FragmentManager supportFragmentManager) {
        this.context = context;
        this.remen = remen;
        this.fentab = fentab;
        this.supportFragmentManager = supportFragmentManager;
    }


    private View one;

    private Remenhuodongrecadapter remenhuodongrecadapter;
    private View two;
    private View zero;


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            zero = LayoutInflater.from(context).inflate(R.layout.zero_item, parent, false);
            return new ViewHolder0(zero);
        } else if (viewType == 1) {
            one = LayoutInflater.from(context).inflate(R.layout.one_item, parent, false);
            return new ViewHolder1(one);
        } else {
            two = LayoutInflater.from(context).inflate(R.layout.two_item, parent, false);
            return new ViewHolder2(two);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 0) {
            ViewHolder0 viewHolder0 = (ViewHolder0) holder;
            Glide.with(context).load(R.drawable.zw1).into(viewHolder0.paozi_img);
            viewHolder0.paozi_tv.setText("袍子");
            Glide.with(context).load(R.drawable.zw2).into(viewHolder0.shetuan_img);
            viewHolder0.paozi_tv.setText("社团");
            Glide.with(context).load(R.drawable.zw1).into(viewHolder0.peihang_img);
            viewHolder0.paozi_tv.setText("排行榜");
        } else if (type == 1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
//            gengduo = viewHolder1.gengduo.findViewById(R.id.gengduo);
//            rec = viewHolder1.huodongrec.findViewById(R.id.rec);
            viewHolder1.huodongrec.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            remenhuodongrecadapter = new Remenhuodongrecadapter(context, remen);
            viewHolder1.huodongrec.setAdapter(remenhuodongrecadapter);
        } else {
//            tab1 = two.findViewById(R.id.tab2);
//            vp = two.findViewById(R.id.vp2);
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            ArrayList<Fragment> fragments = new ArrayList<>();
            for (int i = 0; i < fentab.size(); i++) {
                RedianFragment redianFragment = new RedianFragment();
                fragments.add(redianFragment);
            }
            vpadapter = new Vpadapter(supportFragmentManager, fragments);
            viewHolder2.vp2.setAdapter(vpadapter);
            viewHolder2.tab2.setupWithViewPager(viewHolder2.vp2);
            for (int i = 0; i < fentab.size(); i++) {
                String name = fentab.get(i).getName();
                viewHolder2.tab2.getTabAt(i).setText(name);
            }
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView gengduo;
        public RecyclerView huodongrec;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.gengduo = (TextView) rootView.findViewById(R.id.gengduo);
            this.huodongrec = (RecyclerView) rootView.findViewById(R.id.huodongrec);
        }

    }


    public static
    class ViewHolder0 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView paozi_img;
        public TextView paozi_tv;
        public LinearLayout paozi;
        public ImageView shetuan_img;
        public TextView shetuan_tv;
        public LinearLayout shetuan;
        public ImageView peihang_img;
        public TextView peihang_tv;
        public LinearLayout peihang;

        public ViewHolder0(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.paozi_img = (ImageView) rootView.findViewById(R.id.paozi_img);
            this.paozi_tv = (TextView) rootView.findViewById(R.id.paozi_tv);
            this.paozi = (LinearLayout) rootView.findViewById(R.id.paozi);
            this.shetuan_img = (ImageView) rootView.findViewById(R.id.shetuan_img);
            this.shetuan_tv = (TextView) rootView.findViewById(R.id.shetuan_tv);
            this.shetuan = (LinearLayout) rootView.findViewById(R.id.shetuan);
            this.peihang_img = (ImageView) rootView.findViewById(R.id.peihang_img);
            this.peihang_tv = (TextView) rootView.findViewById(R.id.peihang_tv);
            this.peihang = (LinearLayout) rootView.findViewById(R.id.peihang);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder{
        public View rootView;
        public TabLayout tab2;
        public ViewPager vp2;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tab2 = (TabLayout) rootView.findViewById(R.id.tab2);
            this.vp2 = (ViewPager) rootView.findViewById(R.id.vp2);
        }

    }
}
