package com.dhure.accidentreport;


import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class policy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        WebView myWebView = (WebView) findViewById(R.id.policy);
        myWebView.loadUrl("https://www.insurance.com");
    }

}
