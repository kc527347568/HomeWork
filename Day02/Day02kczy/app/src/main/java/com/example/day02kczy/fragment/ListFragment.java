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
import com.example.day02kczy.adapter.ListAdapter;
import com.example.day02kczy.bean.DataBean;
import com.example.day02kczy.bean.ListBean;
import com.example.day02kczy.persenter.ListPresenter;
import com.example.day02kczy.view.ListView;

import java.util.ArrayList;


public class ListFragment extends Fragment implements ListView {

    private RecyclerView rec_list;
    private ArrayList<DataBean> list;
    private ListAdapter adapter;
    private ListPresenter listPresenter;
    private boolean ok = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listPresenter = new ListPresenter(this);
        initView(view);
        initListener();
        initData();
        ok = true;
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&ok){
            adapter.notifyDataSetChanged();
        }
    }

    private void initListener() {
        adapter.setOnChecked(new ListAdapter.OnChecked() {
            @Override
            public void CheckedListener(int pos) {
                DataBean dataBean = list.get(pos);
                if (dataBean.getHasFollow()) {
                    listPresenter.addDb(dataBean);
                }else {
                    listPresenter.delete(dataBean);
                }
            }
        });
    }

    private void initData() {
        listPresenter.getData();
    }

    private void initView(View view) {
        rec_list = view.findViewById(R.id.rec_list);

        rec_list.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        adapter = new ListAdapter(getContext(), list);
        rec_list.setAdapter(adapter);

        rec_list.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void getData(ListBean listBean) {
        list.addAll(listBean.getData().getData());
        adapter.notifyDataSetChanged();
    }
}