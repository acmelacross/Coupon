package com.fwh.main.fragment;

import android.os.Bundle;

import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import org.xutils.view.annotation.ViewInject;


import coupon.fwh.com.coupon.R;


/**
 * Created by Administrator on 2016/12/7.
 */

public class FragmentOne extends BaseFragment
{

//    @ViewInject(R.id.ft_mine_simple)
//    SimpleDraweeView ft_mine_simple;

    @Override
    public int getLayoutId()
    {

        return R.layout.fragment_main1_index;
    }

    @Override
    public void initVariables()
    {

    }

    @Override
    public void initViews(View view, Bundle savedInstanceState)
    {
        //x.view().inject(this, view);

//        RoundingParams roundingParams =
//                ft_mine_simple.getHierarchy().getRoundingParams();
//        roundingParams.setBorder(R.color.red, 1.0f);
//        roundingParams.setRoundAsCircle(true);
//        ft_mine_simple.getHierarchy().setRoundingParams(roundingParams);
//        Uri u= Uri.parse("http://imgsrc.baidu.com/forum/w%3D580%3Bcp%3Dtieba%2C10%2C749%3Bap%3D%C3%C0%C5%AE%B0%C9%2C90%2C757/sign=4a811ccc4b90f60304b09c4f0929d06b/951001e93901213f780dde2155e736d12f2e9515.jpg");
//        ft_mine_simple.setImageURI(u);

    }

    @Override
    public void initLoadingDatas()
    {
    }



}
