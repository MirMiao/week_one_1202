package com.bw.week_one_1202.model;

import com.bw.week_one_1202.contract.INewsContract;
import com.bw.week_one_1202.entity.NewsEntity;
import com.bw.week_one_1202.utils.NetUtil;
import com.google.gson.Gson;

/**
 * 时间 :2019/12/2  16:10
 * 作者 :苗恒
 * 功能 :
 */
public class NewsModel implements INewsContract.IModel {
    @Override
    public void getData(String url, final ModelCallBack modelCallBack) {
        NetUtil.getInstance().getJson(url, new NetUtil.MyCallBack() {
            @Override
            public void getjsonData(String json) {
                NewsEntity newsEntity = new Gson().fromJson(json, NewsEntity.class);
                modelCallBack.success(newsEntity);
            }
        });
    }
}
