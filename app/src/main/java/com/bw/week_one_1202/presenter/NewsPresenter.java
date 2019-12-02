package com.bw.week_one_1202.presenter;

import com.bw.week_one_1202.contract.INewsContract;
import com.bw.week_one_1202.entity.NewsEntity;
import com.bw.week_one_1202.model.NewsModel;

/**
 * 时间 :2019/12/2  16:14
 * 作者 :苗恒
 * 功能 :
 */
public class NewsPresenter implements INewsContract.Presenter {
   private INewsContract.IView iView;
    private NewsModel newsModel;
    public NewsPresenter(INewsContract.IView iView){
        this.iView=iView;
    }
    @Override
    public void getData(String url) {
        newsModel = new NewsModel();
        newsModel.getData(url, new INewsContract.IModel.ModelCallBack() {
            @Override
            public void success(NewsEntity newsEntity) {
                  //p层得到model层的数据   传递给view层
                 iView.success(newsEntity);
            }
        });
    }
}
