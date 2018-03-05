package com.android.yxd.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.android.yxd.jazzviewpager.R;
import com.android.yxd.test.MyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称 ViewPagerDemo.
 * 包名 com.android.yxd.activity
 * 创建者 yangxd
 * 创建时间  2017/3/13 13:53.
 */

public class MyViewPagerAct extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<ImageView> mImageViews = new ArrayList<ImageView>();

    private int[] pages = { R.mipmap.page_1, R.mipmap.page_2,
            R.mipmap.page_3, R.mipmap.page_4, R.mipmap.page_5, R.mipmap.page_6 };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_page);

        initData();

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mViewPager.setPageTransformer(true, new MyViewPager());

        mViewPager.setAdapter(new PagerAdapter(){
            @Override
            public Object instantiateItem(ViewGroup container, int position){

                container.addView(mImageViews.get(position));
                return mImageViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                container.removeView(mImageViews.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object){
                return view == object;
            }

            @Override
            public int getCount(){
                return pages.length;
            }
        });

    }

    private void initData(){
        for (int imgId : pages) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imgId);
            mImageViews.add(imageView);
        }
    }
}
