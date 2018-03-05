package com.android.yxd.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.yxd.jazzviewpager.R;

import java.util.List;

/**
 * 项目名称 ViewPagerDemo.
 * 包名 com.android.yxd.page
 * 创建者 yangxd
 * 创建时间  2017/3/7 10:14.
 */

public class PageWidgetAdapter extends BaseAdapter {

    private List<Integer> imgList;
    private Context mContext;
    private int count;
    private LayoutInflater inflater;

    public PageWidgetAdapter(Context context, List<Integer> imgList) {
        mContext = context;
        this.imgList = imgList;
        count = imgList.size();
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return count;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return imgList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewGroup layout;
        if(convertView == null) {
            layout = (ViewGroup) inflater.inflate(R.layout.item_page, null);
        } else {
            layout = (ViewGroup) convertView;
        }
        //position有可能超出范围 oys 20150707
        if (position>=0 && position < imgList.size()) {
            setViewContent(layout, position);
        }

        return layout;
    }

    private void setViewContent(ViewGroup group, int position) {
        ImageView iv_img = (ImageView) group.findViewById(R.id.iv_img);
        iv_img.setImageResource(imgList.get(position));
    }

}
