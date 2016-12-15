package com.fwh.modle;

import cn.bmob.v3.BmobObject;

/**
 * 作者--> coding  on 2016/12/16.
 * com.fwh.modle
 * 邮箱--> www14159@163.com
 * Created by coding on 2016/12/16.
 */

public class Goods extends BmobObject {

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public ClassifySmall getGoodType() {
        return goodType;
    }

    public void setGoodType(ClassifySmall goodType) {
        this.goodType = goodType;
    }

    public String getGoodUrl() {
        return goodUrl;
    }

    public void setGoodUrl(String goodUrl) {
        this.goodUrl = goodUrl;
    }

    public String getGoodInfo() {
        return goodInfo;
    }

    public void setGoodInfo(String goodInfo) {
        this.goodInfo = goodInfo;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    private String goodName;
    private ClassifySmall goodType;
    private String goodUrl;
    private String goodInfo;
    private String goodPrice;

    public String getGoodTitle() {
        return goodTitle;
    }

    public void setGoodTitle(String goodTitle) {
        this.goodTitle = goodTitle;
    }

    private String goodTitle;
}
