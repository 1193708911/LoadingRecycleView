package com.ssports.refresh_lib.listener;

/**
 * @author tomcat
 * @creattime 2020-06-04 15:36
 * @description
 */
public interface IStateListener  {


    void   noMoreData();


    void  canLoadMore(boolean canLoadMore);

}
