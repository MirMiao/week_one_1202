package com.bw.week_one_1202.contract;

import com.bw.week_one_1202.entity.NewsEntity;

/**
 * 时间 :2019/12/2  15:59
 * 作者 :苗恒
 * 功能 : 契约管理类,一共包含三个接口,正好对应mvp
 */
public interface INewsContract {
    /**
     * 处理数据,进行网络请求,网络请求
     */
     interface IModel{
        void getData(String url,ModelCallBack modelCallBack);

        interface ModelCallBack{
             void success(NewsEntity newsEntity);
        }
     }
     interface IView{
         void success(NewsEntity newsEntity);//得到对象数据
         void failure(Throwable throwable);
     }
     interface Presenter{
           //传递数据和逻辑处理
          void getData(String url);
     }
}
