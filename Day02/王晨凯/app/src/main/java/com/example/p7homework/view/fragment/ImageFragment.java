package com.example.p7homework.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p7homework.R;
import com.example.p7homework.model.bean.ImageBean;
import com.example.p7homework.presenter.MyPresenter;
import com.example.p7homework.view.IView;

import java.util.ArrayList;
import java.util.List;

public class ImageFragment extends Fragment implements IView {

    private RecyclerView ry_list;
    private FragmentActivity activity;
    private ArrayList<ImageBean.Data.DataBean> list;
    private MyInfoAdapter adapter;
    private MyPresenter myPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        myPresenter = new MyPresenter(this);
        myPresenter.start(12,"pics");
    }

    private void initView(View view) {
        ry_list = view.findViewById(R.id.ry_list_image);

        list = new ArrayList<>();
        adapter = new MyInfoAdapter(activity, list);
        ry_list.setLayoutManager(new LinearLayoutManager(activity));
        ry_list.setAdapter(adapter);
    }

    @Override
    public void successUi(Object object) {
        if(object instanceof ImageBean){
            ImageBean imageBean = (ImageBean) object;
            List<ImageBean.Data.DataBean> data = imageBean.getData().getData();
            list.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void fileUi(String msg) {

    }
}