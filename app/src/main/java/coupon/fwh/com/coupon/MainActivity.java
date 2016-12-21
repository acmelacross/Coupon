package coupon.fwh.com.coupon;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.fwh.main.fragment.FragmentFour;
import com.fwh.main.fragment.FragmentThree;
import com.fwh.main.fragment.FragmentTwo;
import  com.fwh.main.fragment.FragmentOne;

import org.xutils.*;
import org.xutils.BuildConfig;
import org.xutils.view.annotation.ContentView;

import cn.bmob.v3.Bmob;
import cn.smssdk.SMSSDK;

@ContentView(R.layout.activity_main)
public class MainActivity extends FragmentActivity {
    private FragmentManager fm;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentThree fragmentThree;
    private FragmentFour fragmentFour;
    // 未读消息textview
    private TextView unreadLabel;
    // 未读通讯录textview
    private TextView unreadAddressLable;
    private Button[] mTabs;
    private Fragment[] fragments;
    private int index;
    // 当前fragment的index
    private int currentTabIndex;



//  @ViewInject(R.id.main_bottomBar)
//  BottomNavigationBar mMainBottomBar;
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


        //startActivity(new Intent().setClass(MainActivity.this, ShopInfoActivity.class));




//        //打开注册页面
//        RegisterPage registerPage = new RegisterPage();
//        registerPage.setRegisterCallback(new EventHandler() {
//            public void afterEvent(int event, int result, Object data) {
//// 解析注册结果
//                if (result == SMSSDK.RESULT_COMPLETE) {
//                    @SuppressWarnings("unchecked")
//                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
//                    String country = (String) phoneMap.get("country");
//                    String phone = (String) phoneMap.get("phone");
//
//// 提交用户信息（此方法可以不调用）
//                   // registerUser(country, phone);
//                }
//            }
//        });
//        registerPage.show(MainActivity.this);
    }

    private void initBottomBar()
    {
        mTabs = new Button[4];
        mTabs[0] = (Button) findViewById(R.id.btn_conversation);
        mTabs[1] = (Button) findViewById(R.id.btn_address_list);
        mTabs[2] = (Button) findViewById(R.id.btn_setting);
        mTabs[3] = (Button) findViewById(R.id.btn_my);

        // 把第一个tab设为选中状态
        mTabs[0].setSelected(true);


        fragmentOne = new FragmentOne();
        fragmentTwo = new  FragmentTwo();
        fragmentThree = new FragmentThree();
        fragmentFour = new FragmentFour();

        fragments = new Fragment[] { fragmentOne, fragmentTwo,fragmentThree,fragmentFour };
        // 添加显示第一个fragment，
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragmentOne)//.add(R.id.fragment_container, two).hide(two).show(two)
                .commit();




//        mMainBottomBar.setMode(BottomNavigationBar.MODE_FIXED);
//
//        mMainBottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);//BACKGROUND_STYLE_RIPPLE
//
//
//        ;
//        mMainBottomBar.
//                addItem(new BottomNavigationItem(R.drawable.cm, R.string.main_shouye).setActiveColorResource(R.color.red_mogu).setInactiveIcon(getResources().getDrawable(R.drawable.cl)))
//                .addItem(new BottomNavigationItem(R.drawable.cq, R.string.main_shipin).setActiveColorResource(R.color.red_mogu).setInactiveIcon(getResources().getDrawable(R.drawable.cp)))
//                .addItem(new BottomNavigationItem(R.drawable.ck, R.string.main_dongtai).setActiveColorResource(R.color.red_mogu).setInactiveIcon(getResources().getDrawable(R.drawable.cj)))
//                .addItem(new BottomNavigationItem(R.drawable.co, R.string.main_wo).setActiveColorResource(R.color.red_mogu).setInactiveIcon(getResources().getDrawable(R.drawable.cn)))
//                .setFirstSelectedPosition(0)
//
//                .initialise();
//        mMainBottomBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener()
//        {
//            @Override
//            public void onTabSelected(int position)
//            {
//                switch (position)
//                {
//                    case 0:
//                        showFragment(0);
//                        break;
//                    case 1:
//                        showFragment(1);
//                        break;
//                    case 2:
//                        showFragment(2);
//                        break;
//                    case 3:
//                        showFragment(3);
//                        break;
//                    default:
//                        break;
//                }
//            }
//
//            @Override
//            public void onTabUnselected(int position)
//            {
//
//            }
//
//            @Override
//            public void onTabReselected(int position)
//            {
//
//            }
//        });
//        showFragment(0);



    }

    /**
     * button点击事件
     *
     * @param view
     */
    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_container_conversation:
                index = 0;
                break;

            case R.id.btn_conversation:
                index = 0;
                break;

            case R.id.btn_container_address_list:
                index = 1;
                break;
            case R.id.btn_address_list:
                index = 1;
                break;

            case R.id.btn_container_setting:
//                if (!DemoHelper.getInstance().isLoggedIn())
//                    startActivity(new Intent().setClass(this, SetLoginActivity.class));

                index = 2;
                break;
            case R.id.btn_setting:
//                if (!DemoHelper.getInstance().isLoggedIn())
//                    startActivity(new Intent().setClass(this, SetLoginActivity.class));

                index = 2;
                break;

            case R.id.btn_container_my:
                index = 3;

                break;
            case R.id.btn_my:
                index = 3;
                break;


        }
        try {
            ////System.out.println(index+"aaaaaaaaaaaaaaaaaa"+currentTabIndex);
            if (currentTabIndex != index) {
                FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
                trx.hide(fragments[currentTabIndex]);
                if (!fragments[index].isAdded()) {
                    trx.add(R.id.fragment_container, fragments[index]);
                }
                trx.show(fragments[index]).commit();
            }
            mTabs[currentTabIndex].setSelected(false);
            // 把当前tab设为选中状态
            mTabs[index].setSelected(true);
            currentTabIndex = index;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

//    private void showFragment(int position)
//    {
//        FragmentTransaction ft = fm.beginTransaction();
//        hideFragments(ft);
//        switch (position)
//        {
//            case 0:
//                if (mHomeFt != null)
//                {
//                    ft.show(mHomeFt);
//                }else
//                {
//                    mHomeFt = new FragmentOne();
//                    ft.add(R.id.main_frame, mHomeFt);
//                }
//                break;
//            case 1:
//                if (mVideoFt != null)
//                {
//                    ft.show(mVideoFt);
//                }else
//                {
//                    mVideoFt = new FragmentTwo();
//                    ft.add(R.id.main_frame, mVideoFt);
//                }
//                break;
//            case 2:
//                if (mMomentFt != null)
//                {
//                    ft.show(mMomentFt);
//                }else
//                {
//                    mMomentFt = new FragmentThree();
//                    ft.add(R.id.main_frame, mMomentFt);
//                }
//                break;
//            case 3:
//                if (mMineFt != null)
//                {
//                    ft.show(mMineFt);
//                }else
//                {
//                    mMineFt = new FragmentFour();
//                    ft.add(R.id.main_frame, mMineFt);
//                }
//            default:
//                break;
//        }
//        ft.commit();
//
//    }
//
//    private void hideFragments(FragmentTransaction ft)
//    {
//        if (mHomeFt != null)
//        {
//            ft.hide(mHomeFt);
//        }
//        if (mVideoFt != null)
//        {
//            ft.hide(mVideoFt);
//        }
//        if (mMomentFt != null)
//        {
//            ft.hide(mMomentFt);
//        }
//        if (mMineFt != null)
//        {
//            ft.hide(mMineFt);
//        }
//    }

    private void initSDK(){
        x.Ext.init(getApplication());
        //是否是开发、调试模式
        x.Ext.setDebug(BuildConfig.DEBUG);//是否输出debug日志，开启debug会影响性能.
        Fresco.initialize(this);
        Bmob.initialize(this, "2fac321bf36ec6b6b9174ad8a47d3eb5");
        SMSSDK.initSDK(this, "1a11b3c35fbf5", "060a140f3351e80afced49ebd70ee485");
    }

}
