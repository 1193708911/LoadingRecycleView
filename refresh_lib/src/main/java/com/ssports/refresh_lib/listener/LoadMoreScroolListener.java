package com.ssports.refresh_lib.listener;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author tomcat
 * @creattime 2020-05-28 13:27
 * @description
 */
public class LoadMoreScroolListener extends RecyclerView.OnScrollListener {

    private boolean enable = true;
    private LoadMoreListener mLoadMoreListener;

    public void setLoadMoreEnable(boolean enable) {
        this.enable = enable;
    }

    public LoadMoreScroolListener(Context context, LoadMoreListener loadMoreListener) {
        this.mLoadMoreListener = loadMoreListener;
    }

    public void onAppBarScrolled(RecyclerView recyclerView, int x, int verticalY) {
        onScrolled(recyclerView, 0, verticalY);
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();

    }


    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);

        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            if (enable && isBottom(recyclerView)) {
                mLoadMoreListener.onLoadMore();
            }


        }
    }


    private boolean isBottom(RecyclerView recyclerView) {
        if (recyclerView == null)
            return false;

        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
            return true;

        return false;
    }


}
