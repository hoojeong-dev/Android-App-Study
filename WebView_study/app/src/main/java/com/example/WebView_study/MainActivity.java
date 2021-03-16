package com.example.WebView_study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.WedView_study.R;

public class MainActivity extends AppCompatActivity {

    private WebView view;
    private String url = "https://www.naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (WebView)findViewById(R.id.view);

        view.getSettings().getJavaScriptEnabled();
        view.loadUrl(url);
        view.setWebChromeClient(new WebChromeClient());
        view.setWebViewClient(new WebViewClientClass());

    }

    // Back 버튼을 누르면 전으로 돌아감
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()){
            view.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {

        // 현재 페이지의 url을 읽어오는 메소드
        // 해당 메소드를 활용해 새 페이지를 열거나 특정 이벤트 가능
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}