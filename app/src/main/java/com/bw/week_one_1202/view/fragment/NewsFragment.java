package com.bw.week_one_1202.view.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.bw.week_one_1202.R;
import com.bw.week_one_1202.adapter.ProductAdapter;
import com.bw.week_one_1202.base.BaseFragment;
import com.bw.week_one_1202.contract.INewsContract;
import com.bw.week_one_1202.entity.NewsEntity;
import com.bw.week_one_1202.presenter.NewsPresenter;

import java.util.List;

/**
 * 时间 :2019/12/2  15:41
 * 作者 :苗恒
 * 功能 :
 */
public class NewsFragment extends BaseFragment implements INewsContract.IView {
    NewsPresenter newsPresenter;
    private ListView listView;

    @Override
    protected void initData() {
        newsPresenter = new NewsPresenter(this);
        newsPresenter.getData("http://172.17.8.100/small/commodity/v1/commodityList");

    }
    @Override
    protected void initView(View inflate) {
        listView = inflate.findViewById(R.id.lv);
    }
    @Override
    protected int bindLayoutid() {
        return R.layout.newsfragment;
    }
    @Override
    public void success(NewsEntity newsEntity) {
          //请求成功的数据

        List<NewsEntity.ResultBean.RxxpBean.CommodityListBean> commodityList = newsEntity.getResult().getRxxp().getCommodityList();
        //创建适配器
        ProductAdapter productAdapter = new ProductAdapter(getActivity(), commodityList);
        listView.setAdapter(productAdapter);
    }

    @Override
    public void failure(Throwable throwable) {
        Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
    }
}
