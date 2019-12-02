package com.bw.week_one_1202.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bw.week_one_1202.R;
import com.bw.week_one_1202.entity.NewsEntity;
import com.bw.week_one_1202.utils.NetUtil;

import java.util.List;

/**
 * 时间 :2019/12/2  9:16
 * 作者 :苗恒
 * 功能 :
 */
public class ProductAdapter  extends BaseAdapter {
    Context context;
    List<NewsEntity.ResultBean.RxxpBean.CommodityListBean> commodityList;
    public ProductAdapter(Context context, List<NewsEntity.ResultBean.RxxpBean.CommodityListBean> commodityList) {
        this.context=context;
        this.commodityList=commodityList;
    }

    @Override
    public int getCount() {
        return commodityList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
          ViewHolder viewHolder;
          if(view==null){
              view=View.inflate(context, R.layout.adapter_item_layout,null);
              viewHolder=new ViewHolder();
              viewHolder.imageView=view.findViewById(R.id.iv_item);
              viewHolder.tv_name=view.findViewById(R.id.tv_name);
              viewHolder.tv_price=view.findViewById(R.id.tv_price);
              view.setTag(viewHolder);
          }else{
              viewHolder= (ViewHolder) view.getTag();
          }
        viewHolder.tv_name.setText(commodityList.get(i).getCommodityName());
        viewHolder.tv_price.setText(commodityList.get(i).getPrice()+"");
        NetUtil.getInstance().getPhoto(commodityList.get(i).getMasterPic(),viewHolder.imageView);
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView tv_name;
        TextView tv_price;
    }
}
