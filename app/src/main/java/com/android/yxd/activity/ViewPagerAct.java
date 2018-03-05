package com.android.yxd.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Toast;

import com.android.yxd.jazzviewpager.R;
import com.android.yxd.page.PageWidget;
import com.android.yxd.page.PageWidgetAdapter;

/**
 * 项目名称 ViewPagerDemo.
 * 包名 com.android.yxd.activity
 * 创建者 yangxd
 * 创建时间  2017/3/7 18:08.
 */

public class ViewPagerAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_page);

    }

}
