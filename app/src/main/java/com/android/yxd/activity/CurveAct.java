package com.android.yxd.activity;

import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.yxd.curve.Pager;
import com.android.yxd.curve.PagerFactory;
import com.android.yxd.jazzviewpager.R;

import java.io.InputStream;

/**
 * 项目名称 ViewPagerDemo.
 * 包名 com.android.yxd.activity
 * 创建者 yangxd
 * 创建时间  2017/3/2 15:14.
 */

public class CurveAct extends AppCompatActivity {

    private Pager pager;
    private PagerFactory pagerFactory;
    private Bitmap currentBitmap, mCurPageBitmap, mNextPageBitmap;
    private Canvas mCurPageCanvas, mNextPageCanvas;
//    private static final String[] pages = {"page_1", "page_2", "page_3", "page_4", "page_5", "page_6"};
    private int screenWidth;
    private int screenHeight;

    private int[] pages = { R.mipmap.page_1, R.mipmap.page_2,
            R.mipmap.page_3, R.mipmap.page_4, R.mipmap.page_5, R.mipmap.page_6 };


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curve);

        initView();
    }

    private void initView() {

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        pager = new Pager(this, screenWidth, screenHeight);

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addContentView(pager, layoutParams);

        mCurPageBitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        mNextPageBitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);

        mCurPageCanvas = new Canvas(mCurPageBitmap);
        mNextPageCanvas = new Canvas(mNextPageBitmap);
        pagerFactory = new PagerFactory(getApplicationContext());

        pager.setBitmaps(mCurPageBitmap, mCurPageBitmap);
        loadImage(mCurPageCanvas, 0);

        pager.setOnTouchListener(new View.OnTouchListener() {

            private int count = pages.length;
            private int currentIndex = 0;
            private int lastIndex = 0;
            private Bitmap lastBitmap = null;

            @Override
            public boolean onTouch(View v, MotionEvent e) {
                boolean ret = false;
                if (v == pager) {
                    if (e.getAction() == MotionEvent.ACTION_DOWN) {
                        pager.calcCornerXY(e.getX(), e.getY());
                        lastBitmap = currentBitmap;
                        lastIndex = currentIndex;
                        pagerFactory.onDraw(mCurPageCanvas, currentBitmap);
                        if(pager.DragToRight()){
                            if (currentIndex == 0){
                                Toast.makeText(CurveAct.this, "第一页", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            pager.abortAnimation();
                            currentIndex--;
                            loadImage(mNextPageCanvas, currentIndex);
                        }else {
                            if (currentIndex + 1 == count){
                                Toast.makeText(CurveAct.this, "最后一页", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                            pager.abortAnimation();
                            currentIndex++;
                            loadImage(mNextPageCanvas, currentIndex);
                        }
                    } else if (e.getAction() == MotionEvent.ACTION_MOVE) {
                    } else if (e.getAction() == MotionEvent.ACTION_UP) {
                        if (!pager.canDragOver()) {
                            currentIndex = lastIndex;
                            currentBitmap = lastBitmap;
                        }
                    }
                    ret = pager.doTouchEvent(e);
                    return ret;
                }
                return false;
            }
        });
    }

    private void loadImage(final Canvas canvas, int index) {
        Bitmap bitmap = getBitmap(pages[index]);
        currentBitmap = bitmap;
        pagerFactory.onDraw(canvas, bitmap);
        pager.setBitmaps(mCurPageBitmap, mNextPageBitmap);
        pager.postInvalidate();
    }

    private Bitmap getBitmap(int img) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        ApplicationInfo appInfo = getApplicationInfo();
        InputStream is = getResources().openRawResource(img);
        Bitmap tempBitmap = BitmapFactory.decodeStream(is, null, opt);
        int width = tempBitmap.getWidth();
        int height = tempBitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float)screenWidth)/width, ((float)screenHeight)/height);
        Bitmap bitmap = Bitmap.createBitmap(tempBitmap, 0, 0, width, height, matrix, true);
        return bitmap;
    }

}
