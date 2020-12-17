package com.example.wuqi.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wuqi.App;
import com.example.wuqi.R;
import com.example.wuqi.adapter.RecommendAdapter;
import com.example.wuqi.db.ConcernBeanDao;
import com.example.wuqi.model.bean.RecommendBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConcernFragment extends Fragment {

    private ConcernBeanDao concernBeanDao;

    public ConcernFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_concern, container, false);
        //concernBeanDao=App.daoSession.getConcernBeanDao();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());


    }

    private void initView(View view) {
        RecyclerView rel=view.findViewById(R.id.rel);

        rel.setLayoutManager(new LinearLayoutManager(getContext()));

        List<RecommendBean.DataBeanX.DataBean> list=new ArrayList<>();
        RecommendAdapter adapter=new RecommendAdapter(list,getContext());
        rel.setAdapter(adapter);
        



    }
}
