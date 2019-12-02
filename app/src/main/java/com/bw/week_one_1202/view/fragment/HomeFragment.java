package com.bw.week_one_1202.view.fragment;

import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.bw.week_one_1202.R;
import com.bw.week_one_1202.base.BaseFragment;
import com.bw.week_one_1202.view.activity.MainActivity;

/**
 * 时间 :2019/12/2  15:37
 * 作者 :苗恒
 * 功能 :
 */
public class HomeFragment  extends BaseFragment {

    private Button button;

    @Override
    protected void initData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.tiao();
            }
        });
    }

    @Override
    protected void initView(View inflate) {
        button = inflate.findViewById(R.id.bt);
    }

    @Override
    protected int bindLayoutid() {
        return R.layout.homefragment;
    }
}
