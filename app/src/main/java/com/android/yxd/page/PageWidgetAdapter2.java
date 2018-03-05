package com.android.yxd.page;

import java.util.List;

import com.android.yxd.jazzviewpager.R;
import com.android.yxd.view.HtmlWebView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import static com.android.yxd.jazzviewpager.R.id.iv_img;

/**
 * 项目名称 ViewPagerDemo.
 * 包名 com.android.yxd.page
 * 创建者 yangxd
 * 创建时间  2017/3/7 10:14.
 */

public class PageWidgetAdapter2 extends BaseAdapter {

    private List<String> viewList;
    private Context mContext;
    private int count;
    private LayoutInflater inflater;

    public PageWidgetAdapter2(Context context, List<String> viewList) {
        mContext = context;
        this.viewList = viewList;
        count = viewList.size();
//        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return viewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout;
        HtmlWebView webView;
//        if(convertView == null) {
//            layout = (ViewGroup) inflater.inflate(R.layout.item_page2, null);
//        } else {
//            layout = (ViewGroup) convertView;
//        }
        convertView =  LayoutInflater.from(mContext).inflate(R.layout.item_page2,null);

        layout = (LinearLayout) convertView.findViewById(R.id.page_layout);

        webView = (HtmlWebView) convertView.findViewById(R.id.webView);
        //position有可能超出范围 oys 20150707
//        if (position>=0 && position < viewList.size()) {
//            setViewContent(layout, position);
//        }
        webView.setInitialScale(100);
        webView.loadUrl(viewList.get(position));
        return convertView;
    }

    private void setViewContent(LinearLayout view, int position) {

//        HtmlWebView view1 = viewList.get(position);

//        if(view1.getParent() != null) {
//            ViewGroup vg = (ViewGroup) view1.getParent();
//            vg.removeView(view1);
//        }
        HtmlWebView webView = new HtmlWebView(mContext);
        webView.setInitialScale(100);
        webView.loadUrl(viewList.get(position));
        view.addView(webView);

    }

}
