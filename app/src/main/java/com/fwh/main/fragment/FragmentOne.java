package com.fwh.main.fragment;

import android.net.Uri;
import android.os.Bundle;

import android.view.View;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


import coupon.fwh.com.coupon.R;


/**
 * Created by Administrator on 2016/12/7.
 */

public class FragmentOne extends BaseFragment
{

    @ViewInject(R.id.ft_mine_simple)
    SimpleDraweeView ft_mine_simple;

    @Override
    public int getLayoutId()
    {
        return R.layout.ft_mine;
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
        Uri u= Uri.parse("http://pic44.nipic.com/20140721/11624852_001107119409_2.jpg");
        ft_mine_simple.setImageURI(u);

    }

    @Override
    public void initLoadingDatas()
    {
    }



}
