package com.android.yxd.activity;

import java.util.ArrayList;
import java.util.List;

import com.android.yxd.jazzviewpager.R;
import com.android.yxd.page.PageWidget;
import com.android.yxd.page.PageWidgetAdapter;
import com.android.yxd.page.PageWidgetAdapter2;
import com.android.yxd.view.HtmlWebView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * 项目名称 ViewPagerDemo.
 * 包名 com.android.yxd.activity
 * 创建者 yangxd
 * 创建时间  2017/3/7 10:03.
 */

public class PageAct2 extends AppCompatActivity {

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
                Toast.makeText(PageAct2.this, "点泥煤", Toast.LENGTH_SHORT).show();
            }
        });

        //查询数据
        queryData();
    }

    private void queryData(){
        List<String> viewList = new ArrayList<>();

//        HtmlWebView wv1 = new HtmlWebView(this);
//        wv1.setInitialScale(100);
        viewList.add("file:///android_asset/end.html");
//        viewList.add(wv1);

//        HtmlWebView wv2 = new HtmlWebView(this);
//        wv2.setInitialScale(100);
        viewList.add("file:///android_asset/end1.html");
//        viewList.add(wv2);
//
//        HtmlWebView wv3 = new HtmlWebView(this);
//        wv3.setInitialScale(100);
//        wv3.loadUrl("file:///android_asset/end.html");
//        viewList.add(wv3);
//
//        HtmlWebView wv4 = new HtmlWebView(this);
//        wv4.setInitialScale(100);
//        wv4.loadUrl("file:///android_asset/book1.html");
//        viewList.add(wv4);
//
//        HtmlWebView wv5 = new HtmlWebView(this);
//        wv5.setInitialScale(100);
//        wv5.loadUrl("file:///android_asset/end.html");
//        viewList.add(wv5);
//
//        HtmlWebView wv6 = new HtmlWebView(this);
//        wv6.setInitialScale(100);
//        wv6.loadUrl("file:///android_asset/book1.html");
//        viewList.add(wv6);

        PageWidgetAdapter2 adapter = new PageWidgetAdapter2(this, viewList);
        pageWidget.setAdapter(adapter);
    }
}
