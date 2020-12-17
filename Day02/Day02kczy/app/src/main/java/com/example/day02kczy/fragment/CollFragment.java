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
import com.example.day02kczy.adapter.CollAdapter;
import com.example.day02kczy.adapter.ListAdapter;
import com.example.day02kczy.bean.DataBean;
import com.example.day02kczy.bean.ListBean;
import com.example.day02kczy.persenter.CollPresenter;
import com.example.day02kczy.persenter.ListPresenter;
import com.example.day02kczy.view.CollView;
import com.example.day02kczy.view.ListView;

import java.util.ArrayList;
import java.util.List;

public class CollFragment extends Fragment implements CollView {


    private RecyclerView rec_coll;
    private ArrayList<DataBean> list;
    private CollPresenter collPresenter;
    private boolean ok = false;
    private CollAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coll, container, false);
        collPresenter = new CollPresenter(this);
        initView(view);
        initListener();
        ok = true;
        return view;
    }

    private void initListener() {
        adapter.setOnChecked(new CollAdapter.OnChecked() {
            @Override
            public void CheckedListener(int pos) {
                DataBean dataBean = list.get(pos);
                collPresenter.delete(dataBean);
                dataBean.setHasFollow(false);
                list.clear();
                collPresenter.getData();
            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser&&ok){
            if (list!=null&&list.size()>0) {
                list.clear();
            }
            collPresenter.getData();
        }
    }

    private void initView(View view) {
        rec_coll = view.findViewById(R.id.rec_coll);
        rec_coll.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        adapter = new CollAdapter(getContext(), list);
        rec_coll.setAdapter(adapter);

        rec_coll.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }


    @Override
    public void getData(List<DataBean> beans) {

            list.addAll(beans);
            adapter.notifyDataSetChanged();

    }
}