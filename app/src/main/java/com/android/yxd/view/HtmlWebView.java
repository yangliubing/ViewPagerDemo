package com.android.yxd.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 项目名: ViewPagerDemo
 * 包名:com.android.yxd.view
 * Author: yangxd
 * 创建时间: 2017/6/220:02
 * 备注: describe this class purpose
 */
public class HtmlWebView extends WebView {

    public HtmlWebView(Context context) {
        super(context);
        init(context);
    }

    public HtmlWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 基础参数
     *
     * @param context
     */
    private void init(Context context){
        requestFocusFromTouch();
        requestFocus();
        getSettings().setAllowFileAccess(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUseWideViewPort(true);// 关键点
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //充满webview（flash，img）
        getSettings().setLoadWithOverviewMode(false);
        //设置可以支持缩放
        getSettings().setSupportZoom(false);
        //设置显示放大缩小按钮
        getSettings().setBuiltInZoomControls(false);
        //设定缩放控件隐藏
        getSettings().setDisplayZoomControls(false);
        //设置是否支持新窗口
        getSettings().setSupportMultipleWindows(true);
        // 启用地理定位
        getSettings().setGeolocationEnabled(false);
        // 让网页自适应屏幕宽度
        getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        getSettings().setUseWideViewPort(true);
        //开启DOM缓存
        getSettings().setDomStorageEnabled(true);
        getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        // 设置背景色
        setBackgroundColor(Color.TRANSPARENT);
        //拦截跳转浏览器
        setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (URLUtil.isValidUrl(url)) {
                    view.loadUrl(url);
                    view.requestFocus();
                }
                return true;
            }
        });
    }

    /**
     * 加载html代码
     *
     * @param url
     */
    public void loadDataWithBaseURL(String url){
        loadDataWithBaseURL("fake://not/needed", url, "text/html", "utf-8", "");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        return false;
    }

}
