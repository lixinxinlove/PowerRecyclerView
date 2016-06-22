package com.lixinxin.powerrecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lixinxin.powerrecyclerview.adapter.XAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private XAdapter xAdapter;
    private XRecyclerView xRecyclerView;
    private List<String> lists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        initData();

    }

    private void initView() {
        xRecyclerView = (XRecyclerView) findViewById(R.id.recyclerView);
        xRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {

        lists = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            lists.add("I Love Android" + " " + i + " Day");
        }
        xAdapter = new XAdapter(lists);
        xRecyclerView.setAdapter(xAdapter);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        // mAdapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        // mAdapter.notifyDataSetChanged();
                        xRecyclerView.loadMoreComplete();
                    }
                }, 1000);
            }
        });

    }
}
