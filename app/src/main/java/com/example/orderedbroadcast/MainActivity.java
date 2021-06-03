package com.example.orderedbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //动态注册广播接收者One
        IntentFilter filter1 = new IntentFilter();
        filter1.addAction("Intercept_Stitch");
        filter1.setPriority(1000);
        this.registerReceiver(new MyBroadcastReceiverOne(), filter1);
        //动态注册广播接收者Two
        IntentFilter filter2 = new IntentFilter();
        filter2.addAction("Intercept_Stitch");
        filter2.setPriority(200);
        this.registerReceiver(new MyBroadcastReceiverTwo(), filter2);
        //动态注册广播接收者Three
        IntentFilter filter3 = new IntentFilter();
        filter3.addAction("Intercept_Stitch");
        filter3.setPriority(600);
        this.registerReceiver(new MyBroadcastReceiverThree(), filter3);
    }

    //点击发送有序广播按钮执行的方法
    public void send(View view) {
        Intent intent = new Intent();
        // 定义广播的事件类型
        intent.setAction("Intercept_Stitch");
        // 发送广播
        sendOrderedBroadcast(intent, null);
    }
}
