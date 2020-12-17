package com.example.wuqi.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wuqi.R;
import com.example.wuqi.adapter.PictureAdapter;
import com.example.wuqi.model.bean.PictureBean;
import com.example.wuqi.presenter.PicturePresenter;
import com.example.wuqi.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment implements IView{


    private List<PictureBean.DataBeanX.DataBean> list;
    private PictureAdapter adapter;

    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_picture, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
    }

    private void initData() {
        PicturePresenter presenter=new PicturePresenter(this);
        presenter.start();
    }

    private void initView(View view) {
        RecyclerView rel=view.findViewById(R.id.rel);

        rel.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new PictureAdapter(list,getContext());
        rel.setAdapter(adapter);

    }

    @Override
    public void showSuccessUi(Object obj) {
        if (obj instanceof PictureBean){
            List<PictureBean.DataBeanX.DataBean> data=((PictureBean) obj).getData().getData();
            list.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showFailData(String msg) {

    }
}
