package com.miqt.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.miqt.costtime.Cost;

import wangyuwei.me.demo.R;

public class MainActivity extends AppCompatActivity {

    public static String hello1 = "hello";
    public String hello2 = "hello";
    public final String hello3 = "hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show(null);
    }

    @Cost
    public void show(View view) {
        Log.v("tag", hello1 + hello2 + hello3);
    }
}
