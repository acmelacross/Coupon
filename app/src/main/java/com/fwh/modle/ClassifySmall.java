package com.fwh.modle;

import cn.bmob.v3.BmobObject;

/**
 * 作者--> coding  on 2016/12/16.
 * com.fwh.modle
 * 邮箱--> www14159@163.com
 * Created by coding on 2016/12/16.
 */
public class ClassifySmall extends BmobObject {

    private ClassifyBig classifyType;

    public ClassifyBig getClassifyType() {
        return classifyType;
    }

    public void setClassifyType(ClassifyBig classifyType) {
        this.classifyType = classifyType;
    }

    private String classifyName;

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getClassifyImg() {
        return classifyImg;
    }

    public void setClassifyImg(String classifyImg) {
        this.classifyImg = classifyImg;
    }

    private String classifyImg;
}
