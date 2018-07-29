package com.example.tracksystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        String file="file:///android_asset/about.html";
        WebView w=(WebView)findViewById(R.id.aboutweb);
         w.loadUrl(file);
    }
}
