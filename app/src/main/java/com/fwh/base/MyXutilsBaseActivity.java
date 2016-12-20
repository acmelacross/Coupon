package com.fwh.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import org.xutils.x;

/**
 * 作者--> coding  on 2016/12/19.
 * com.fwh.base
 * 邮箱--> www14159@163.com
 * Created by coding on 2016/12/19.
 */

public class MyXutilsBaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}
