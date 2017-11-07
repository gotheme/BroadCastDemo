package com.gothemes.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Kundan Kamal on 11/7/2017.
 * Copyright (c)2017 AppsInvo.com
 */

public class SecondActivity extends AppCompatActivity {

    Button btnSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnSecond=findViewById(R.id.btn_next);
        btnSecond.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
                                         }
                                     }
        );


        IntentFilter intentFilter=new IntentFilter("Action_Dynamic");
        BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                finish();

            }
        };
        registerReceiver(broadcastReceiver,intentFilter);
    }

    }
