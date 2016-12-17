package coupon.fwh.com.coupon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.fwh.main.fragment.FragmentFour;
import com.fwh.main.fragment.FragmentThree;
import com.fwh.main.fragment.FragmentTwo;
import com.fwh.modle.ClassifyBig;
import com.fwh.modle.ClassifySmall;
import com.fwh.modle.Goods;
import com.fwh.modle.Person;
import  com.fwh.main.fragment.FragmentOne;

import org.xutils.*;
import org.xutils.BuildConfig;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;
    private FragmentOne mHomeFt;
    private FragmentTwo mVideoFt;
    private FragmentThree mMomentFt;
    private FragmentFour mMineFt;
  @ViewInject(R.id.main_bottomBar)
  BottomNavigationBar mMainBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initSDK();

//        Person p2 = new Person();
//        p2.setName("lucky");
//        p2.setAddress("北京海淀");
//        p2.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId,BmobException e) {
//                if(e==null){
//                   System.out.print("成功 ");
//                }else{
//                    System.out.print("失败 ");
//                }
//            }
//        });123123


//        ClassifyBig big = new ClassifyBig();
//        big.setObjectId("5541c44013");
//        big.setClassifyName("家用电器");
//        ClassifySmall small = new ClassifySmall();
//        small.setClassifyType(big);
//        //small.setClassifyName("彩电影音");
//        small.setObjectId("014a111575");
//        Goods good = new Goods();
//        good.setGoodName("测试");
//        good.setGoodType(small);
//        good.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId,BmobException e) {
//                if(e==null){
//                   System.out.print("成功 "+objectId);
//                }else{
//                    System.out.print("失败 ");
//                }
//            }
//        });

        fm = getSupportFragmentManager();
        initBottomBar();
    }

    private void initBottomBar()
    {
        mMainBottomBar.setMode(BottomNavigationBar.MODE_FIXED);
        mMainBottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mMainBottomBar.
                addItem(new BottomNavigationItem(R.drawable.main_tab_tool_btn_pressed, R.string.main_shouye).setActiveColorResource(R.color.orange_main).setInactiveIcon(getResources().getDrawable(R.drawable.main_tab_tool_bg_normal)))
                .addItem(new BottomNavigationItem(R.drawable.main_tab_micro_video_bg_pressed, R.string.main_shipin).setActiveColorResource(R.color.orange_main).setInactiveIcon(getResources().getDrawable(R.drawable.main_tab_micro_video_bg_normal)))
                .addItem(new BottomNavigationItem(R.drawable.main_tab_moment_bg_pressed, R.string.main_dongtai).setActiveColorResource(R.color.orange_main).setInactiveIcon(getResources().getDrawable(R.drawable.main_tab_moment_bg_normal)))
                .addItem(new BottomNavigationItem(R.drawable.main_tab_me_bg_pressed, R.string.main_wo).setActiveColorResource(R.color.orange_main).setInactiveIcon(getResources().getDrawable(R.drawable.main_tab_me_bg_normal)))
                .setFirstSelectedPosition(0)
                .initialise();
        mMainBottomBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(int position)
            {
                switch (position)
                {
                    case 0:
                        showFragment(0);
                        break;
                    case 1:
                        showFragment(1);
                        break;
                    case 2:
                        showFragment(2);
                        break;
                    case 3:
                        showFragment(3);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position)
            {

            }

            @Override
            public void onTabReselected(int position)
            {

            }
        });
        showFragment(0);
    }

    private void showFragment(int position)
    {
        FragmentTransaction ft = fm.beginTransaction();
        hideFragments(ft);
        switch (position)
        {
            case 0:
                if (mHomeFt != null)
                {
                    ft.show(mHomeFt);
                }else
                {
                    mHomeFt = new FragmentOne();
                    ft.add(R.id.main_frame, mHomeFt);
                }
                break;
            case 1:
                if (mVideoFt != null)
                {
                    ft.show(mVideoFt);
                }else
                {
                    mVideoFt = new FragmentTwo();
                    ft.add(R.id.main_frame, mVideoFt);
                }
                break;
            case 2:
                if (mMomentFt != null)
                {
                    ft.show(mMomentFt);
                }else
                {
                    mMomentFt = new FragmentThree();
                    ft.add(R.id.main_frame, mMomentFt);
                }
                break;
            case 3:
                if (mMineFt != null)
                {
                    ft.show(mMineFt);
                }else
                {
                    mMineFt = new FragmentFour();
                    ft.add(R.id.main_frame, mMineFt);
                }
            default:
                break;
        }
        ft.commit();

    }

    private void hideFragments(FragmentTransaction ft)
    {
        if (mHomeFt != null)
        {
            ft.hide(mHomeFt);
        }
        if (mVideoFt != null)
        {
            ft.hide(mVideoFt);
        }
        if (mMomentFt != null)
        {
            ft.hide(mMomentFt);
        }
        if (mMineFt != null)
        {
            ft.hide(mMineFt);
        }
    }

    private void initSDK(){
        x.Ext.init(getApplication());
        //是否是开发、调试模式
        x.Ext.setDebug(BuildConfig.DEBUG);//是否输出debug日志，开启debug会影响性能.
        Fresco.initialize(this);
        Bmob.initialize(this, "2fac321bf36ec6b6b9174ad8a47d3eb5");
    }

}
