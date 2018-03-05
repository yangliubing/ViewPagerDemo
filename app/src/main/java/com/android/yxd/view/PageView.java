package com.android.yxd.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yxd.jazzviewpager.R;

/**
 * 项目名: ViewPagerDemo
 * 包名:com.android.yxd.view
 * Author: yangxd
 * 创建时间: 2017/6/222:34
 * 备注: describe this class purpose
 */
public class PageView extends FrameLayout {

    public PageView(@NonNull Context context) {
        super(context);
        init();
    }

    public PageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PageView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //初始
    private void init(){
        //图片
        ImageView img1 = new ImageView(getContext());
        FrameLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        params.bottomMargin = 10;
        params.gravity = Gravity.BOTTOM;
        img1.setImageResource(R.mipmap.img01);
        img1.setLayoutParams(params);
        addView(img1);

        ImageView img2 = new ImageView(getContext());
        img2.setImageResource(R.mipmap.img02);
        addView(img2);

        //文字
        TextView tv1 = new TextView(getContext());
        tv1.setText("测试哈哈哈");
        tv1.setTextSize(24);
        addView(tv1);
    }
}
