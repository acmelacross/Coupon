package com.fwh.modle;

import cn.bmob.v3.BmobObject;


/**
 * 作者--> coding  on 2016/12/16.
 * com.fwh.modle
 * 邮箱--> www14159@163.com
 * Created by coding on 2016/12/16.
 */
public class Person extends BmobObject {


//
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}