package com.fwh.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fwh.main.fragment.two.LeftListAdapter;
import com.fwh.main.fragment.two.PinnedHeaderListView;
import com.fwh.main.fragment.two.RightSectionedAdapter;
import com.fwh.view.activity.BuyActivity;

import org.xutils.view.annotation.ViewInject;

import coupon.fwh.com.coupon.MainActivity;
import coupon.fwh.com.coupon.R;




/**
 * Created by Administrator on 2016/12/7.
 */

public class FragmentTwo extends BaseFragment
{

    @ViewInject(R.id.left_listview)
    ListView leftListview;
    @ViewInject(R.id.pinnedListView)
    private PinnedHeaderListView pinnedListView;
    private boolean isScroll = true;
    private LeftListAdapter adapter;


    private String[] leftStr = new String[]{"面食类", "盖饭", "寿司", "烧烤", "酒水", "凉菜", "小吃", "粥", "休闲","自定义1"};
    private boolean[] flagArray = {true, false, false, false, false, false, false, false, false,false};
    private String[][] rightStr = new String[][]{{"热干面", "臊子面", "烩面"},
            {"番茄鸡蛋", "红烧排骨", "农家小炒肉"},
            {"芝士", "丑小丫", "金枪鱼"}, {"羊肉串", "烤鸡翅", "烤羊排"}, {"长城干红", "燕京鲜啤", "青岛鲜啤"},
            {"拌粉丝", "大拌菜", "菠菜花生"}, {"小食组", "紫薯"},
            {"小米粥", "大米粥", "南瓜粥", "玉米粥", "紫米粥"}, {"儿童小汽车", "悠悠球", "熊大", " 熊二", "光头强"}
            , {"自定义1", "自定义1", "自定义1", " 自定义1", "自定义1"}
    };



    @Override
    public int getLayoutId()
    {
        return R.layout.fragment_main2_classify;
    }

    @Override
    public void initVariables()
    {

    }

    @Override
    public void initViews(View view, Bundle savedInstanceState)
    {



        //  = (PinnedHeaderListView) findViewById(R.id.pinnedListView);
        final RightSectionedAdapter sectionedAdapter = new RightSectionedAdapter(this.getActivity(), leftStr, rightStr);
        pinnedListView.setAdapter(sectionedAdapter);
        adapter = new LeftListAdapter(this.getActivity(), leftStr, flagArray);
        leftListview.setAdapter(adapter);
        leftListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                isScroll = false;

                for (int i = 0; i < leftStr.length; i++) {
                    if (i == position) {
                        flagArray[i] = true;
                    } else {
                        flagArray[i] = false;
                    }
                }
                adapter.notifyDataSetChanged();
                int rightSection = 0;
                for (int i = 0; i < position; i++) {
                    rightSection += sectionedAdapter.getCountForSection(i) + 1;
                }
                pinnedListView.setSelection(rightSection);

            }

        });

        pinnedListView.setOnItemClickListener(new AdapterView.OnItemClickListener(

        ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("aaaaaa   " + i);
                startActivity(new Intent().setClass(getActivity(), BuyActivity.class));

            }
        });

        pinnedListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView arg0, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (pinnedListView.getLastVisiblePosition() == (pinnedListView.getCount() - 1)) {
                            leftListview.setSelection(ListView.FOCUS_DOWN);
                        }

                        // 判断滚动到顶部
                        if (pinnedListView.getFirstVisiblePosition() == 0) {
                            leftListview.setSelection(0);
                        }

                        break;
                }
            }

            int y = 0;
            int x = 0;
            int z = 0;

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (isScroll) {
                    for (int i = 0; i < rightStr.length; i++) {
                        if (i == sectionedAdapter.getSectionForPosition(pinnedListView.getFirstVisiblePosition())) {
                            flagArray[i] = true;
                            x = i;
                        } else {
                            flagArray[i] = false;
                        }
                    }
                    if (x != y) {
                        adapter.notifyDataSetChanged();
                        y = x;
                        if (y == leftListview.getLastVisiblePosition()) {
//                            z = z + 3;
                            leftListview.setSelection(z);
                        }
                        if (x == leftListview.getFirstVisiblePosition()) {
//                            z = z - 1;
                            leftListview.setSelection(z);
                        }
                        if (firstVisibleItem + visibleItemCount == totalItemCount - 1) {
                            leftListview.setSelection(ListView.FOCUS_DOWN);
                        }
                    }
                } else {
                    isScroll = true;
                }
            }
        });

    }

    @Override
    public void initLoadingDatas()
    {
    }



}
