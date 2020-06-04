package com.ssports.refresh_lib.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.ssports.refresh_lib.listener.FooterInterface;
import com.ssports.refresh_lib.listener.IStateListener;
import com.ssports.refresh_lib.listener.LoadMoreScroolListener;

/**
 * @author tomcat
 * @creattime 2020-06-04 15:36
 * @description
 */
public class SRecycleView extends RecyclerView implements IStateListener {
    private OnScrollListener mOnScroolListener;

    public SRecycleView(@NonNull Context context) {
        super(context);
    }

    public SRecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SRecycleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void noMoreData() {
        Adapter adapter = this.getAdapter();
        if (adapter != null && adapter instanceof AdapterWraper) {
            ((AdapterWraper) adapter).noMoreData();

        }
        if (mOnScroolListener != null && mOnScroolListener instanceof LoadMoreScroolListener) {
            LoadMoreScroolListener mOnScroolListener = (LoadMoreScroolListener) this.mOnScroolListener;
            mOnScroolListener.setLoadMoreEnable(false);
        }

    }

    @Override
    public void canLoadMore(boolean canLoadMore) {
        Adapter adapter = this.getAdapter();
        if (adapter != null && adapter instanceof AdapterWraper) {
            ((AdapterWraper) adapter).setCanLoadMore(false);
        }
        if (mOnScroolListener != null && mOnScroolListener instanceof LoadMoreScroolListener) {
            LoadMoreScroolListener mOnScroolListener = (LoadMoreScroolListener) this.mOnScroolListener;
            mOnScroolListener.setLoadMoreEnable(false);
        }
    }

    @Override
    public void addOnScrollListener(@NonNull OnScrollListener listener) {
        this.mOnScroolListener = listener;
        super.addOnScrollListener(listener);
    }

    public void addFootView(FooterInterface footView) {
        Adapter adapter = this.getAdapter();
        if (adapter != null && adapter instanceof AdapterWraper) {
            ((AdapterWraper) adapter).addFooter(footView);
        }

    }
}
