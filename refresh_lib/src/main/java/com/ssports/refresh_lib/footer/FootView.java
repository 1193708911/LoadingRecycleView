package com.ssports.refresh_lib.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ssports.refresh_lib.listener.FooterInterface;
import com.ssports.refresh_lib.R;

/**
 * @author tomcat
 * @creattime 2020-06-04 14:26
 * @description
 */
public class FootView extends FootViewTable implements FooterInterface {

    private ProgressBar mProgressCircular;
    private TextView mTxtTip;

    public FootView(Context context) {
        super(context);
        init();

    }

    public FootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_footer, this);
        mProgressCircular = findViewById(R.id.progress_circular);
        mTxtTip = findViewById(R.id.txt_tip);
    }


    @Override
    public void noMoreData() {
        mProgressCircular.setVisibility(GONE);
        mTxtTip.setText("没有数据了");
    }
}
