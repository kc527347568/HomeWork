package com.example.p7homework.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p7homework.App;
import com.example.p7homework.R;
import com.example.p7homework.model.bean.DataBean;
import com.example.p7homework.model.bean.ApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecoFragment extends Fragment {

    private RecyclerView ry_list;
    private FragmentActivity activity;
    private ArrayList<DataBean> list;
    private MyRecoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        View view = inflater.inflate(R.layout.fragment_reco, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder().baseUrl(ApiService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService.class)
                .getReCo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecoBean value) {
                        List<DataBean> data = value.getData().getData();
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

    private void initView(View view) {
        ry_list = view.findViewById(R.id.ry_list_reCo);

        list = new ArrayList<>();
        adapter = new MyRecoAdapter(activity, list);
        ry_list.setLayoutManager(new LinearLayoutManager(activity));
        ry_list.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL));
        ry_list.setAdapter(adapter);

        adapter.setListener(new MyRecoAdapter.ItemListener() {
            @Override
            public void itemClick(int p) {

            }
        });
    }
}