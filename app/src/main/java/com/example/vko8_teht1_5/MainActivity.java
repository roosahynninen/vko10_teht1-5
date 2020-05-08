package com.example.vko8_teht1_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText address;
    String prev;
    String next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
    }

    public void getWWW(View v){
        address = findViewById(R.id.editText);
        web.loadUrl("http://" + address.getText().toString());
    }

    public void refresh(View v){
        web.reload();
    }

    public void next (View v){
        if(web!= null && web.canGoForward()){
            web.goForward();
        }
    }

    public void back (View v) {
        next = web.getUrl();
        if (web != null && web.canGoBack()) {
            web.goBack();
            prev = web.getUrl();
        } else {
            System.out.println("Nothing to show");
        }
    }
}
