package com.ssports.video;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ssports.refresh_lib.view.AdapterWraper;
import com.ssports.refresh_lib.footer.FootView;
import com.ssports.refresh_lib.listener.LoadMoreListener;
import com.ssports.refresh_lib.listener.LoadMoreScroolListener;
import com.ssports.refresh_lib.view.SRecycleView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoadMoreListener {

    private SRecycleView mRecycleview;
    private List<String> mDatas = new ArrayList<>();
    private AdapterWraper adapterWraper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleview = findViewById(R.id.recycleview);

        for (int i = 0; i < 100; i++) {
            mDatas.add(i + "haha");
        }

        LinearLayoutManager manager = new LinearLayoutManager(this);
        DataAdapter adapter = new DataAdapter(this, mDatas);
        adapterWraper = new AdapterWraper(this, adapter);
        mRecycleview.setLayoutManager(manager);
        LoadMoreScroolListener loadMoreScroolListener = new LoadMoreScroolListener(this, this);
        mRecycleview.addOnScrollListener(loadMoreScroolListener);
        mRecycleview.setAdapter(adapterWraper);
        mRecycleview.addFootView(new FootView(this));

    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    mDatas.add(i + "haha");
                }
                adapterWraper.notifyDataSetChanged();
                mRecycleview.noMoreData();
            }
        }, 1000);


    }


    public class DataAdapter extends RecyclerView.Adapter {
        public Context mContext;
        private List<String> mList;

        public DataAdapter(Context mContext, List<String> mList) {
            this.mContext = mContext;
            this.mList = mList;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(new TextView(mContext));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof ViewHolder) {
                ViewHolder viewholder = (ViewHolder) holder;
                viewholder.mTxtView.setText(mList.get(position) + "111111");

            }
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }


        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView mTxtView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                this.mTxtView = (TextView) itemView;

            }
        }
    }
}
