package com.ssports.refresh_lib.view;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ssports.refresh_lib.footer.FootView;
import com.ssports.refresh_lib.footer.FootViewTable;
import com.ssports.refresh_lib.listener.FooterInterface;

import java.util.LinkedList;

/**
 * @author tomcat
 * @creattime 2020-06-04 10:19
 * @description 自定义加载更多适配器包装类
 */
public class AdapterWraper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int PAGE_SIZE = 10;//一页加载多少
    public static final int VIEW_TYPE_FOOT = 1;//加载更多数据
    public static final int VIEW_TYPE_ITEM = 2;//条目
    private RecyclerView.Adapter mDataAdapter;
    public Context mContext;
    public boolean isCanLoadMore = true;

    public LinkedList<FooterInterface> mFooterViews = new LinkedList();

    public void setCanLoadMore(boolean canLoadMore) {
        isCanLoadMore = canLoadMore;
        notifyDataSetChanged();
    }

    public AdapterWraper(Context context, RecyclerView.Adapter adapter) {
        this.mDataAdapter = adapter;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (isCanLoadMore && mFooterViews.size() > 0) {
            if (position == getItemCount() - 1) {
                return VIEW_TYPE_FOOT;
            } else {
                return VIEW_TYPE_ITEM;
            }
        } else {
            return VIEW_TYPE_ITEM;
        }


    }

    @Override
    public int getItemCount() {
        return (isCanLoadMore && mFooterViews.size() > 0) ? mDataAdapter.getItemCount() + 1 : mDataAdapter.getItemCount();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_ITEM:
                return mDataAdapter.createViewHolder(parent, viewType);
            case VIEW_TYPE_FOOT:
                return new FootViewHolder((FootViewTable) mFooterViews.get(0));
        }
        return mDataAdapter.createViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FootViewHolder) {
            ((FootViewHolder) holder).bindData(position);
        } else {
            mDataAdapter.onBindViewHolder(holder, position);
        }

    }


    private class FootViewHolder extends RecyclerView.ViewHolder {
        public FootViewHolder(FootViewTable footView) {
            super(footView);
        }

        public void bindData(int position) {

        }
    }

    /**
     * 添加footview
     *
     * @param footView
     */
    public void addFooter(FooterInterface footView) {
        if (footView == null) {
            footView = new FootView(mContext);
        }
        mFooterViews.remove(footView);
        mFooterViews.add(footView);
        notifyDataSetChanged();
    }


    public void noMoreData() {
        if (mFooterViews.size() > 0) {
            FooterInterface footView = mFooterViews.get(0);
            footView.noMoreData();
            notifyDataSetChanged();
        }
    }

}
