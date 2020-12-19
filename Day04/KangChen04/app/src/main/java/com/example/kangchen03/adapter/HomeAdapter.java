package com.example.kangchen03.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.example.kangchen03.R;
import com.example.kangchen03.bean.ReMengBean;
import com.example.kangchen03.bean.TitleBean;
import com.example.kangchen03.mainFragment.ListFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<TitleBean.DataBean> titleList;
    private ArrayList<ReMengBean.DataBean> reMenList;
    private final FragmentManager supportFragmentManager;


    public HomeAdapter(Context context, ArrayList<TitleBean.DataBean> titleList, ArrayList<ReMengBean.DataBean> reMenList, FragmentManager supportFragmentManager) {
        this.context = context;
        this.titleList = titleList;
        this.reMenList = reMenList;
        this.supportFragmentManager = supportFragmentManager;
    }

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
            View view0 = LayoutInflater.from(context).inflate(R.layout.item_img, parent, false);
            return new ViewHolder0(view0);
        } else if (viewType == 1) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_rec_re, parent, false);
            return new ViewHolder1(view1);
        } else {
            View view2 = LayoutInflater.from(context).inflate(R.layout.item_fregment, parent, false);
            return new ViewHolder2(view2);
        }
    }

    private OnClick0 onClick0;

    public void setOnClick0(OnClick0 onClick0) {
        this.onClick0 = onClick0;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 0) {
            final ViewHolder0 viewHolder0 = (ViewHolder0) holder;
            Glide.with(context).load(R.drawable.zzz).apply(new RequestOptions().circleCrop()).into(viewHolder0.iv_pai);
            Glide.with(context).load(R.drawable.vvv).apply(new RequestOptions().circleCrop()).into(viewHolder0.iv_she);
            Glide.with(context).load(R.drawable.xxx).apply(new RequestOptions().circleCrop()).into(viewHolder0.iv_pao);

            viewHolder0.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder0.li_pai.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onClick0.OnClickPai();
                        }
                    });
                    viewHolder0.li_she.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onClick0.OnClickShe();
                        }
                    });
                    viewHolder0.li_pao.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onClick0.OnClickPao();
                        }
                    });
                }
            });
        } else if (type == 1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            viewHolder1.rec_re.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

            ReAdapter adapter = new ReAdapter(context, reMenList);
            viewHolder1.rec_re.setAdapter(adapter);
        } else {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;

            ArrayList<String> title = new ArrayList<>();
            ArrayList<Fragment> list = new ArrayList<>();
            TitleAdapter adapter = new TitleAdapter(supportFragmentManager, list, title);
            viewHolder2.vwv_home.setAdapter(adapter);
            viewHolder2.tab_home.setupWithViewPager(viewHolder2.vwv_home);
            for (int i = 0; i < titleList.size(); i++) {
//                ListFragment listFragment = new com.example.kangchen03.mainFragment.ListFragment();
                ListFragment listFragment = new ListFragment();
                list.add(listFragment);
                title.add(titleList.get(i).getName());

                Bundle bundle = new Bundle();
                bundle.putInt("id",titleList.get(i).getType());
                listFragment.setArguments(bundle);

            }
            adapter.notifyDataSetChanged();
        }

    }

    public interface OnClick0 {
        void OnClickPai();

        void OnClickShe();

        void OnClickPao();

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static
    class ViewHolder0 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_pao;
        public LinearLayout li_pao;
        public ImageView iv_she;
        public LinearLayout li_she;
        public ImageView iv_pai;
        public LinearLayout li_pai;

        public ViewHolder0(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_pao = (ImageView) rootView.findViewById(R.id.iv_pao);
            this.li_pao = (LinearLayout) rootView.findViewById(R.id.li_pao);
            this.iv_she = (ImageView) rootView.findViewById(R.id.iv_she);
            this.li_she = (LinearLayout) rootView.findViewById(R.id.li_she);
            this.iv_pai = (ImageView) rootView.findViewById(R.id.iv_pai);
            this.li_pai = (LinearLayout) rootView.findViewById(R.id.li_pai);
        }

    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rec_re;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rec_re = (RecyclerView) rootView.findViewById(R.id.rec_re);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TabLayout tab_home;
        public ViewPager vwv_home;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tab_home = (TabLayout) rootView.findViewById(R.id.tab_home);
            this.vwv_home = (ViewPager) rootView.findViewById(R.id.vwv_home);
        }

    }
}
