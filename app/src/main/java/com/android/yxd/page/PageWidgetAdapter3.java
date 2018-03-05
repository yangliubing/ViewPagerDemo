package com.android.yxd.page;

import java.util.List;

import com.android.yxd.jazzviewpager.R;
import com.android.yxd.view.PageView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * 项目名称 ViewPagerDemo.
 * 包名 com.android.yxd.page
 * 创建者 yangxd
 * 创建时间  2017/3/7 10:14.
 */

public class PageWidgetAdapter3 extends BaseAdapter {

    private List<View> imgList;
    private Context mContext;
    private int count;
    private LayoutInflater inflater;

    public PageWidgetAdapter3(Context context, List<View> imgList) {
        mContext = context;
        this.imgList = imgList;
        count = imgList.size();
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return imgList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewGroup layout;
        if(convertView == null) {
            layout = (ViewGroup) inflater.inflate(R.layout.item_page3, null);
        } else {
            layout = (ViewGroup) convertView;
        }

        PageView page = (PageView) layout.findViewById(R.id.page_layout);

        return layout;
    }

}
