package com.example.sghospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity5 extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        web=findViewById(R.id.web);
        web.loadUrl("https://www.who.int/");
        web.setWebViewClient(new Web());
    }
}