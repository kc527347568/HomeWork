package com.example.kangchen03.mainFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kangchen03.R;
import com.example.kangchen03.adapter.ListAdapter;
import com.example.kangchen03.bean.ItemBean;
import com.example.kangchen03.presenter.ListPresenter;
import com.example.kangchen03.view.ListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;


public class ListFragment extends Fragment implements ListView {

    private RecyclerView rec_list;
    private ArrayList<ItemBean.DataBean.ListBean> list;
    private ListAdapter adapter;
    private int id;
    private ListPresenter listPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Bundle arguments = getArguments();
        id = arguments.getInt("id");
        Log.e("TAG", "run:" + id);
        listPresenter = new ListPresenter(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        listPresenter.getData(id);
    }

    private void initView(View view) {
        rec_list = view.findViewById(R.id.rec_list);

        rec_list.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        adapter = new ListAdapter(getContext(), list);
        rec_list.setAdapter(adapter);

        rec_list.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

    }


    @Override
    public void getData(ItemBean itemBean) {
        list.addAll(itemBean.getData().getList());
        adapter.notifyDataSetChanged();
    }
}