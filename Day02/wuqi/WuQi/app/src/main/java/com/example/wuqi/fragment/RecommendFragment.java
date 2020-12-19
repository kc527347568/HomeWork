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
import com.example.wuqi.adapter.RecommendAdapter;
import com.example.wuqi.db.ConcernBeanDao;
import com.example.wuqi.model.ApiSerivice;
import com.example.wuqi.model.bean.ConcernBean;
import com.example.wuqi.model.bean.RecommendBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {


    private List<RecommendBean.DataBeanX.DataBean> list;
    private RecommendAdapter adapter;
    private int pos;

    private ConcernBeanDao concernBeanDao;
    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    private void initView(View view) {
        RecyclerView rel=view.findViewById(R.id.rel);

        rel.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new RecommendAdapter(list,getContext());
        rel.setAdapter(adapter);

        initData();

        initListener();
    }

    private void initListener() {
        adapter.setOnItemClick(new RecommendAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position) {
                pos = position;
                ConcernBean concernBean=new ConcernBean();

                RecommendBean.DataBeanX.DataBean bean=list.get(pos);
                concernBean.setIcon(bean.getIcon());
                concernBean.setTitle(bean.getTitle());
                concernBean.setContent(bean.getIntro());
                concernBeanDao.insert(concernBean);
            }
        });
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiSerivice.BASE_URL1)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiSerivice.class)
                .getRecommend()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecommendBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecommendBean value) {
                        List<RecommendBean.DataBeanX.DataBean> data=value.getData().getData();
                        list.addAll(data);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
