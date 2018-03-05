package com.android.yxd.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.android.yxd.jazzviewpager.JazzyViewPager;
import com.android.yxd.jazzviewpager.OutlineContainer;
import com.android.yxd.jazzviewpager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */

public class MyBookAct extends AppCompatActivity {

    private JazzyViewPager mJazzy;

    private List<View> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_book);

        //初始化View
        initView();
        //初始化
        initData();
    }

    private void initView(){
        mJazzy = (JazzyViewPager) findViewById(R.id.jazzy_pager);
    }

    private void initData(){
        //初始数据
        WebView webView1 = new WebView(MyBookAct.this);
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (URLUtil.isValidUrl(url)) {
                    view.loadUrl(url);
                    view.requestFocus();
                }
                return true;
            }
        });
        webView1.loadUrl("file:///android_asset/book1.html");
        bookList.add(webView1);
        WebView webView2 = new WebView(MyBookAct.this);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (URLUtil.isValidUrl(url)) {
                    view.loadUrl(url);
                    view.requestFocus();
                }
                return true;
            }
        });
        webView2.loadUrl("file:///android_asset/book1.html");
        bookList.add(webView2);
        WebView webView3 = new WebView(MyBookAct.this);
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (URLUtil.isValidUrl(url)) {
                    view.loadUrl(url);
                    view.requestFocus();
                }
                return true;
            }
        });
        webView3.loadUrl("file:///android_asset/book1.html");
        bookList.add(webView3);
        WebView webView4 = new WebView(MyBookAct.this);
        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (URLUtil.isValidUrl(url)) {
                    view.loadUrl(url);
                    view.requestFocus();
                }
                return true;
            }
        });
        webView4.loadUrl("file:///android_asset/book1.html");
        bookList.add(webView4);

        //初始化adapter
        mJazzy.setTransitionEffect(JazzyViewPager.TransitionEffect.Accordion);
        mJazzy.setAdapter(new BookAdapter());
    }

    private class BookAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return bookList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = bookList.get(position);
            container.addView(view);
            mJazzy.setObjectForPosition(view, position);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object obj) {
            container.removeView(mJazzy.findViewFromObject(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            if (view instanceof OutlineContainer) {
                return ((OutlineContainer) view).getChildAt(0) == obj;
            } else {
                return view == obj;
            }
        }
    }
}
