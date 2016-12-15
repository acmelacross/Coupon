package com.fwh.modle;

import cn.bmob.v3.BmobObject;

/**
 * Created by coding on 2016/12/14.
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
}
