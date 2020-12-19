package com.example.kangchen03.mainFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kangchen03.R;
import com.example.kangchen03.adapter.HomeAdapter;
import com.example.kangchen03.bean.ItemBean;
import com.example.kangchen03.bean.ReMengBean;
import com.example.kangchen03.bean.TitleBean;
import com.example.kangchen03.presenter.HomePresenter;
import com.example.kangchen03.view.HomeView;

import java.util.ArrayList;

public class BlankFragment2 extends Fragment implements HomeView {

    private RecyclerView rec_home;
    private ArrayList<TitleBean.DataBean> titleList;
    private ArrayList<ReMengBean.DataBean> reMenList;
    private HomeAdapter adapter;
    private HomePresenter homePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        homePresenter = new HomePresenter(this);
        initView(view);
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        adapter.setOnClick0(new HomeAdapter.OnClick0() {
            @Override
            public void OnClickPai() {
                Log.e("TAG","run:"+"跳排行榜");
            }

            @Override
            public void OnClickShe() {
                Log.e("TAG","run:"+"跳社团");

            }

            @Override
            public void OnClickPao() {
                Log.e("TAG","run:"+"跳袍子");

            }
        });
    }

    private void initData() {
        homePresenter.getData();
    }

    private void initView(View view) {
        rec_home = view.findViewById(R.id.rec_home);

        rec_home.setLayoutManager(new LinearLayoutManager(getActivity()));

        reMenList = new ArrayList<>();
        titleList = new ArrayList<>();

        adapter = new HomeAdapter(getContext(), titleList, reMenList,getActivity().getSupportFragmentManager());

        rec_home.setAdapter(adapter);
    }

    @Override
    public void getRe(ReMengBean reMengBean) {
        reMenList.addAll(reMengBean.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getTitle(TitleBean titleBean) {
        titleList.addAll(titleBean.getData());
        adapter.notifyDataSetChanged();
    }
}