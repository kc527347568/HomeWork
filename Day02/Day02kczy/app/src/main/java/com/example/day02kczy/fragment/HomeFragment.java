package com.example.day02kczy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day02kczy.MainActivity;
import com.example.day02kczy.R;
import com.example.day02kczy.adapter.HomeAdapter;
import com.example.day02kczy.bean.TuBean;
import com.example.day02kczy.persenter.HomePresenter;
import com.example.day02kczy.view.HomeView;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements HomeView {

    private RecyclerView rec_home;
    private HomePresenter homePresenter;
    private ArrayList<TuBean.DataBeanX.DataBean> list;
    private HomeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        homePresenter = new HomePresenter(this);
        initView(view);
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        adapter.setOnClick(new HomeAdapter.OnClick() {
            @Override
            public void OnClickListener(int pos) {
                TuBean.DataBeanX.DataBean dataBean = list.get(pos);
                int likeCount = dataBean.getAuthor().getLikeCount();
                likeCount++;
                list.get(pos).getAuthor().setLikeCount(likeCount);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initData() {
        homePresenter.getData();
    }

    private void initView(View view) {
        rec_home = view.findViewById(R.id.rec_home);

        rec_home.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        adapter = new HomeAdapter(getContext(), list);
        rec_home.setAdapter(adapter);

        rec_home.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

    }

    @Override
    public void getData(TuBean tuBean) {
        list.addAll(tuBean.getData().getData());
        adapter.notifyDataSetChanged();
    }
}