package com.ssports.refresh_lib.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ssports.refresh_lib.listener.FooterInterface;

/**
 * @author tomcat
 * @creattime 2020-06-04 16:07
 * @description 基类
 */
public class FootViewTable extends RelativeLayout implements FooterInterface {

    public FootViewTable(@NonNull Context context) {
        super(context);
    }

    public FootViewTable(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FootViewTable(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void noMoreData() {

    }
}
