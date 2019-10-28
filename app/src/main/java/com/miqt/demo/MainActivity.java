package com.miqt.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.miqt.costtime.Cost;

import wangyuwei.me.demo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show(null);
    }

    @Cost
    public void show(View view) {
        for (int i = 0; i < 100; i++) {
            Log.v("----", i + "");
        }
    }
}
