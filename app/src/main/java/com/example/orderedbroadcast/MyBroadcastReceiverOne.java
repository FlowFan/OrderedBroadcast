package com.example.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadcastReceiverOne extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //优先权最高打开新页面
        Intent intent1 = new Intent(context, MainActivity2.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
        Log.i("MyBroadcastReceiver", "自定义的广播接收者One,接收到了广播事件");
    }
}
