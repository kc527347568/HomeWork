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
import com.example.day02kczy.adapter.TextAdapter;
import com.example.day02kczy.bean.TextBean;
import com.example.day02kczy.bean.TuBean;
import com.example.day02kczy.persenter.TextPresenter;
import com.example.day02kczy.view.TextView;

import java.util.ArrayList;

public class TextFragment extends Fragment implements TextView {

    private RecyclerView rec_text;
    private ArrayList<TextBean.DataBeanX.DataBean> list;
    private TextAdapter adapter;
    private TextPresenter textPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        textPresenter = new TextPresenter(this);
        initView(view);
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        adapter.setOnClick(new TextAdapter.OnClick() {
            @Override
            public void OnClickListener(int pos) {
                TextBean.DataBeanX.DataBean dataBean = list.get(pos);
                int likeCount = dataBean.getAuthor().getLikeCount();
                likeCount++;
                list.get(pos).getAuthor().setLikeCount(likeCount);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initData() {
        textPresenter.getData();
    }

    private void initView(View view) {
        rec_text = view.findViewById(R.id.rec_text);

        rec_text.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        adapter = new TextAdapter(getContext(), list);
        rec_text.setAdapter(adapter);

        rec_text.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void getData(TextBean textBean) {
        list.addAll(textBean.getData().getData());
        adapter.notifyDataSetChanged();
    }
}