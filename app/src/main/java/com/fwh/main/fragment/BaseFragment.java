package com.fwh.main.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;

/**
 * Created by Administrator on 2016/12/7.
 */

public abstract class BaseFragment extends Fragment
{
    public abstract int getLayoutId();

    public abstract void initVariables();

    public abstract void initViews(View view, Bundle savedInstanceState);

    public abstract void initLoadingDatas();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View views = inflater.inflate(getLayoutId(), container, false);
        x.view().inject(this, views);
        initVariables();
        initViews(views, savedInstanceState);
        initLoadingDatas();
        return views;
    }
}
