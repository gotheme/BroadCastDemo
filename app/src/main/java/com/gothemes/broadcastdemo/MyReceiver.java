package com.gothemes.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Kundan Kamal on 11/7/2017.
 * Copyright (c)2017 AppsInvo.com
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.w("MY_DEBUG_TAG", state);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                //receive number  which is coming in  call.
                String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.w("MY_DEBUG_TAG", phoneNumber);
             //   Utils.iNumberCallBack.numberCallback(phoneNumber);
                Intent intent1=new Intent("Action_Static");
                intent1.putExtra("number",phoneNumber);
                context.sendBroadcast(intent1);
                if(Utils.firstActivity!=null) {
                    Utils.iNumberCallBack.numberCallback(phoneNumber);
                }
            }
        }
    }


}
