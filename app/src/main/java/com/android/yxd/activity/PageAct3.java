package com.android.yxd.activity;

import java.util.ArrayList;
import java.util.List;

import com.android.yxd.jazzviewpager.R;
import com.android.yxd.page.PageWidget;
import com.android.yxd.page.PageWidgetAdapter;
import com.android.yxd.page.PageWidgetAdapter3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

/**
 * 项目名称 ViewPagerDemo.
 * 包名 com.android.yxd.activity
 * 创建者 yangxd
 * 创建时间  2017/3/7 10:03.
 */

public class PageAct3 extends AppCompatActivity {

    private PageWidget pageWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_page);

        pageWidget = (PageWidget) findViewById(R.id.pageWidget);

        pageWidget.setOnClickPage(new PageWidget.OnClickPage() {
            @Override
            public void onClick() {
                Toast.makeText(PageAct3.this, "点泥煤", Toast.LENGTH_SHORT).show();
            }
        });

        //查询数据
        queryData();
    }

    private void queryData(){
        List<View> imgList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            imgList.add(new View(this));
        }

        PageWidgetAdapter3 adapter = new PageWidgetAdapter3(this, imgList);
        pageWidget.setAdapter(adapter);
    }
}
