package com.gothemes.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gothemes.broadcastdemo.interfaces.INumberCallBack;

import java.util.ArrayList;
import java.util.logging.Logger;

public class FirstActivity extends AppCompatActivity implements INumberCallBack {

    private ListView listView;
    private ArrayList<String> numberList=new ArrayList<>();

    private  ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Utils.iNumberCallBack=FirstActivity.this;
        listView = (ListView) findViewById(R.id.lv_listview);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, numberList);
        listView.setAdapter(arrayAdapter);


        IntentFilter intentFilter=new IntentFilter("Action_Static");
        BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String  number=intent.getStringExtra("number");
                if(number!=null) {
                    setAdapter(number);
                }
            }
        };
        registerReceiver(broadcastReceiver,intentFilter);
    }

    /*
    * set adapter
    * */
    public  void setAdapter(String number)
    {
        numberList.add(number);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void numberCallback(String number) {
        Log.e("numbreCallback---","isCalling");
        setAdapter(number);
    }
}
