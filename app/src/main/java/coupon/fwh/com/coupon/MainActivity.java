package coupon.fwh.com.coupon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fwh.modle.ClassifyBig;
import com.fwh.modle.ClassifySmall;
import com.fwh.modle.Person;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "2fac321bf36ec6b6b9174ad8a47d3eb5");

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

        ClassifyBig big = new ClassifyBig();
        big.setObjectId("5541c44013");
        big.setClassifyName("家用电器");
        ClassifySmall small = new ClassifySmall();
        small.setClassifyType(big);
        small.setClassifyName("彩电影音");
        small.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                   System.out.print("成功 "+objectId);
                }else{
                    System.out.print("失败 ");
                }
            }
        });

    }
}
