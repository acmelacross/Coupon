package com.fwh.view.activity.userinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fwh.base.MyXutilsBaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import coupon.fwh.com.coupon.R;
@ContentView(R.layout.activity_customer)
public class CustomerActivity extends MyXutilsBaseActivity {
@ViewInject(R.id.webView)
WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        //WebView加载web资源
        webview.loadUrl("https://static.meiqia.com/dist/standalone.html?eid=46303");
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
}
