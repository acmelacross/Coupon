package com.fwh.view.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.fwh.base.CommonAdapter;
import com.fwh.base.MyXutilsBaseActivity;
import com.fwh.base.ViewHolder;
import com.fwh.modle.Goods;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import coupon.fwh.com.coupon.R;

@ContentView(R.layout.activity_shop_info)
public class ShopInfoActivity extends MyXutilsBaseActivity {

@ViewInject(R.id.lvShopInfo)
    ListView lvShopInfo;
    List<Goods> list = new ArrayList<Goods>() ;
    CommonAdapter mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }
    private void initView() {
        Goods g = new Goods();
        g.setGoodName("买二送一澳洲原装进口GM绵羊油");
        g.setGoodInfo("60年金品品牌,天然抗菌,舒适健康,柔软亲肤,排湿吸汗,月销过万,好评如潮");
        g.setGoodPrice("券后仅需[69]包邮");
        g.setGoodUrl("http://act.shangpin.com/brand/Activities/20140504SP_MARGARIN/images/img01.jpg");
        list.add(g);
        list.add(g);
        list.add(g);
        list.add(g);
        //Toast.makeText(ShopInfoActivity.this,"aaaaaaa",Toast.LENGTH_SHORT).show();
        lvShopInfo.setAdapter(
                mAdapter= new CommonAdapter<Goods>( ShopInfoActivity.this, list, R.layout.l_item_shopinfo) {
                    @Override
                    public void convert(ViewHolder helper, Goods item) {

                helper.setText(R.id.tvShopName, item.getGoodName());
                helper.setText(R.id.tvShopInfo, item.getGoodInfo());
                 helper.setText(R.id.tvShopPrice, item.getGoodPrice());
                 helper.setSdvImageByUrl(R.id.sdvShopImgs,item.getGoodUrl());
                    }
                }
        );



//        lvShopInfo.setAdapter(mAdapter = new CommonAdapter(
//                getApplicationContext(), list, R.layout.l_item_shopinfo)
//        {
//            public void convert(ViewHolder helper, Goods item)
//            {
//                helper.setText(R.id.tvShopName, item.getGoodName());
//                helper.setText(R.id.tvShopInfo, item.getGoodInfo());
////                helper.setText(R.id.tv_phone, item.getPhone());
////                helper.setText(R.id.tv_time, item.getTime());
//
////              helper.getView(R.id.tv_title).setOnClickListener(l)
//
//            }
//
//        });
    }


}
