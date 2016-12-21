package com.fwh.main.fragment;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fwh.base.CommonAdapter;
import com.fwh.base.ViewHolder;
import com.fwh.base.YLListView;
import com.fwh.modle.Goods;
import com.fwh.modle.UserInfo;
import com.fwh.view.activity.ShopInfoActivity;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import coupon.fwh.com.coupon.R;




/**
 * Created by Administrator on 2016/12/7.
 */

public class FragmentFour extends BaseFragment
{

    @ViewInject(R.id.listView)
    YLListView listView;


    List list = new ArrayList<UserInfo>();
    CommonAdapter mAdapter;
    @Override
    public int getLayoutId()
    {
        return R.layout.framgent_main4_user_center;
    }

    @Override
    public void initVariables()
    {

    }

    @Override
    public void initViews(View view, Bundle savedInstanceState)
    {
        View topView=View.inflate(getActivity(),R.layout.view_user_center_top,null);

        SimpleDraweeView  ft_mine_simple =(SimpleDraweeView)topView.findViewById(R.id.ft_mine_simple);
        Uri u= Uri.parse("http://imgsrc.baidu.com/forum/w%3D580%3Bcp%3Dtieba%2C10%2C749%3Bap%3D%C3%C0%C5%AE%B0%C9%2C90%2C757/sign=4a811ccc4b90f60304b09c4f0929d06b/951001e93901213f780dde2155e736d12f2e9515.jpg");
        ft_mine_simple.setImageURI(u);

        listView.addHeaderView(topView);


//        View bottomView=View.inflate(getActivity(),R.layout.view_user_center_top,null);
//        listView.addFooterView(bottomView);

        // 顶部和底部也可以固定最终的高度 不固定就使用布局本身的高度
//        listView.setFinalBottomHeight(100);

        final float scale = getActivity().getResources().getDisplayMetrics().density;
        ;
        listView.setFinalTopHeight( (int) (150 * scale + 0.5f));

       // listView.setAdapter(new DemoAdapter());
        initAdapter();
    }

    @Override
    public void initLoadingDatas()
    {

    }
private void initAdapter(){
    UserInfo item = new UserInfo();
    item.setImgRes(R.drawable.my_wallet);
    item.setName("我的订单");

    UserInfo item2 = new UserInfo();
    item2.setImgRes(R.drawable.my_love);
    item2.setName("我购物车");

    UserInfo item3 = new UserInfo();
    item3.setImgRes(R.drawable.my_crash);
    item3.setName("我的钱包");

    UserInfo item4 = new UserInfo();
    item4.setImgRes(R.drawable.my_customer_service);
    item4.setName("联系客服");

    UserInfo item6 = new UserInfo();
    item6.setImgRes(R.drawable.my_apress);
    item6.setName("业务合作");

    UserInfo item5 = new UserInfo();
    item5.setImgRes(R.drawable.my_about);
    item5.setName("关于");

    list.add(item);
    list.add(item2);
    list.add(item3);
    list.add(item4);
    list.add(item6);

    list.add(item5);

//    UserInfo item6 = new UserInfo();
//    item6.setImgRes(R.drawable.my_love);
//    item6.setName("我购物车");



    listView.setAdapter(
            mAdapter= new CommonAdapter<UserInfo>( getActivity(), list, R.layout.l_item_user_center) {
                @Override
                public void convert(ViewHolder helper, UserInfo item) {
                    helper.setText(R.id.tvUserCenterText, item.getName());
                    helper.setImageResource(R.id.ivUserCenterIcon,item.getImgRes());
                }
            }
    );
}


}

