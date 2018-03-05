package com.android.yxd.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.yxd.jazzviewpager.JazzyViewPager;
import com.android.yxd.jazzviewpager.OutlineContainer;
import com.android.yxd.jazzviewpager.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    private Button btn13;
    private Button btn14;
    private Button btn15;
    private Button btn16;
    private Button btn17;
    private Button btn18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.btn_9);
        btn9.setOnClickListener(this);
        btn10 = (Button) findViewById(R.id.btn_10);
        btn10.setOnClickListener(this);
        btn11 = (Button) findViewById(R.id.btn_11);
        btn11.setOnClickListener(this);
        btn12 = (Button) findViewById(R.id.btn_12);
        btn12.setOnClickListener(this);
        btn13 = (Button) findViewById(R.id.btn_13);
        btn13.setOnClickListener(this);
        btn14 = (Button) findViewById(R.id.btn_14);
        btn14.setOnClickListener(this);
        btn15 = (Button) findViewById(R.id.btn_15);
        btn15.setOnClickListener(this);
        btn16 = (Button) findViewById(R.id.btn_16);
        btn16.setOnClickListener(this);
        btn17 = (Button) findViewById(R.id.btn_17);
        btn17.setOnClickListener(this);
        btn18 = (Button) findViewById(R.id.btn_18);
        btn18.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                startActivity(new Intent(MainActivity.this, ViewPagerAct1.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(MainActivity.this, ViewPagerAct2.class));
                break;
            case R.id.btn_3:
                startActivity(new Intent(MainActivity.this, ViewPagerAct3.class));
                break;
            case R.id.btn_4:
                startActivity(new Intent(MainActivity.this, ViewPagerAct4.class));
                break;
            case R.id.btn_5:
                startActivity(new Intent(MainActivity.this, ViewPagerAct5.class));
                break;
            case R.id.btn_6:
                startActivity(new Intent(MainActivity.this, ViewPagerAct6.class));
                break;
            case R.id.btn_7:
                startActivity(new Intent(MainActivity.this, ViewPagerAct7.class));
                break;
            case R.id.btn_8:
                startActivity(new Intent(MainActivity.this, ViewPagerAct8.class));
                break;
            case R.id.btn_9:
                startActivity(new Intent(MainActivity.this, ViewPagerAct9.class));
                break;
            case R.id.btn_10:
                startActivity(new Intent(MainActivity.this, ViewPagerAct10.class));
                break;
            case R.id.btn_11:
                startActivity(new Intent(MainActivity.this, ViewPagerAct11.class));
                break;
            case R.id.btn_12:
                startActivity(new Intent(MainActivity.this, ViewPagerAct12.class));
                break;
            case R.id.btn_13:
                startActivity(new Intent(MainActivity.this, CurlActivity.class));
                break;
            case R.id.btn_14:
                startActivity(new Intent(MainActivity.this, CurveAct.class));
                break;
            case R.id.btn_15:
                startActivity(new Intent(MainActivity.this, PageAct3.class));
                break;
            case R.id.btn_16:
                startActivity(new Intent(MainActivity.this, ViewPagerAct.class));
                break;
            case R.id.btn_17:
                startActivity(new Intent(MainActivity.this, MyViewPagerAct.class));
                break;
            case R.id.btn_18:
                startActivity(new Intent(MainActivity.this, MyBookAct.class));
                break;
        }
    }
}
