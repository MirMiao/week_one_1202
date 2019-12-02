package com.bw.week_one_1202.base;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 时间 :2019/12/2  15:32
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BaseActivity extends AppCompatActivity {
   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(bindLayoutid());
        initView();
        initData();
   }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int bindLayoutid();


}
