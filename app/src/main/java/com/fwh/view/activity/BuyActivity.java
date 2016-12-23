package com.fwh.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.fwh.base.CommonAdapter;
import com.fwh.base.MyXutilsBaseActivity;
import com.fwh.base.ViewHolder;
import com.fwh.modle.Goods;
import com.fwh.modle.UserInfo;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import coupon.fwh.com.coupon.R;
@ContentView(R.layout.activity_buy)
public class BuyActivity extends MyXutilsBaseActivity {
    @ViewInject(R.id.gvActivityBuy)
    GridView gvActivityBuy;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  setContentView(R.layout.activity_buy);


        CommonAdapter mAdapter;
        List<Goods> list = new ArrayList<Goods>() ;


        Goods g = new Goods();
        g.setGoodName("买二送一澳洲原装进口GM绵羊油");
        g.setGoodInfo("60年金品品牌,天然抗菌,舒适健康,柔软亲肤,排湿吸汗,月销过万,好评如潮");
        g.setGoodPrice("券后仅需[69]包邮");
        g.setGoodUrl("http://b1.hucdn.com/upload/item/1604/26/43785702548474_800x800.jpg!350x350.jpg");
        list.add(g);
        list.add(g);
        list.add(g);
        list.add(g);
        //Toast.makeText(BuyActivity.this,"aaaaaaa",Toast.LENGTH_SHORT).show();
        gvActivityBuy.setAdapter(
                 mAdapter= new CommonAdapter<Goods>( BuyActivity.this, list, R.layout.g_item_shopinfo) {
                    @Override
                    public void convert(ViewHolder helper, Goods item) {

                        helper.setText(R.id.tvShopName, item.getGoodName());
                        helper.setText(R.id.tvShopInfo, item.getGoodInfo());
                        helper.setText(R.id.tvShopPrice, item.getGoodPrice());
                        helper.setSdvImageByUrl(R.id.sdvShopImgs,item.getGoodUrl());
                    }
                }
        );
    }
}
