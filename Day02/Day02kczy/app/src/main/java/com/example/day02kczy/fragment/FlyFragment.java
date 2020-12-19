package com.example.day02kczy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02kczy.R;
import com.example.day02kczy.adapter.FlyAdapter;
import com.example.day02kczy.adapter.HomeAdapter;
import com.example.day02kczy.bean.ShiBean;
import com.example.day02kczy.bean.TuBean;
import com.example.day02kczy.persenter.FlyPresenter;
import com.example.day02kczy.persenter.HomePresenter;
import com.example.day02kczy.view.FlyView;

import java.util.ArrayList;


public class FlyFragment extends Fragment implements FlyView {

    private RecyclerView rec_fly;
    private ArrayList<ShiBean.DataBeanX.DataBean> list;
    private FlyAdapter adapter;
    private FlyPresenter flyPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fly, container, false);
        flyPresenter = new FlyPresenter(this);
        initView(view);
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        adapter.setOnClick(new FlyAdapter.OnClick() {
            @Override
            public void OnClickListener(int pos) {
                ShiBean.DataBeanX.DataBean dataBean = list.get(pos);
                int likeCount = dataBean.getAuthor().getLikeCount();
                likeCount++;
                list.get(pos).getAuthor().setLikeCount(likeCount);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initData() {
        flyPresenter.getData(getContext());
    }

    private void initView(View view) {
        rec_fly = view.findViewById(R.id.rec_fly);

        rec_fly.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList();
        adapter = new FlyAdapter(getContext(), list);
        rec_fly.setAdapter(adapter);

        rec_fly.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void getData(ShiBean shiBean) {
        list.addAll(shiBean.getData().getData());
        adapter.notifyDataSetChanged();
    }
}