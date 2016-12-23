package com.fwh.main.fragment;

import android.os.Bundle;

import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fwh.base.banner.GlideImageLoader;
import com.youth.banner.Banner;

import org.xutils.view.annotation.ViewInject;


import java.util.ArrayList;
import java.util.List;

import coupon.fwh.com.coupon.R;


/**
 * Created by Administrator on 2016/12/7.
 */

public class FragmentOne extends BaseFragment
{

//    @ViewInject(R.id.ft_mine_simple)
//    SimpleDraweeView ft_mine_simple;
    @ViewInject(R.id.banner)
        Banner banner;
List<String> images = new ArrayList<>();
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

initBanner(view);
    }



    @Override
    public void initLoadingDatas()
    {
    }

    private void initBanner(View view) {



        images.add("http://b1.hucdn.com/upload/show/1612/06/12041350030341_750x350.jpg!hphb.jpg");
        images.add("http://b1.hucdn.com/upload/show/1612/20/22124525354852_750x350.jpg!hphb.jpg");
        images.add("http://b1.hucdn.com/upload/show/1612/16/78987220633635_750x350.jpg!hphb.jpg");
        images.add("http://b1.hucdn.com/upload/show/1612/14/97228099139615_750x350.jpg!hphb.jpg");
        images.add("http://b1.hucdn.com/upload/show/1612/01/02389995925217_750x350.jpg!hphb.jpg");

       // Banner banner = (Banner) view.findViewById(R.id.banner);
        banner.setImages(images).setImageLoader(new GlideImageLoader()).start();
    }
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }





//    Banner banner = (Banner) findViewById(R.id.banner);
//    //设置banner样式
//    banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//    //设置图片加载器
//    banner.setImageLoader(new GlideImageLoader());
//    //设置图片集合
//    banner.setImages(images);
//    //设置banner动画效果
//    banner.setBannerAnimation(Transformer.DepthPage);
//    //设置标题集合（当banner样式有显示title时）
//    banner.setBannerTitles(titles);
//    //设置自动轮播，默认为true
//    banner.isAutoPlay(true);
//    //设置轮播时间
//    banner.setDelayTime(1500);
//    //设置指示器位置（当banner模式中有指示器时）
//    banner.setIndicatorGravity(BannerConfig.CENTER);
//    //banner设置方法全部调用完毕时最后调用
//    banner.start();

}
