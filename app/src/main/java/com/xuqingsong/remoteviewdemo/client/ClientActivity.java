package com.xuqingsong.remoteviewdemo.client;

import com.xuqingsong.remoteviewdemo.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RemoteViews;

public class ClientActivity extends AppCompatActivity {

    //声明一个LinearLayout
    private LinearLayout mRemoteViewContent;

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            RemoteViews remoteViews = intent.getParcelableExtra("remoteview");

            if (remoteViews != null) {

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        IntentFilter intentFilter = new IntentFilter("com.xuqingsong.remoteview");
        registerReceiver(mReceiver, intentFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    private void updateUI(RemoteViews remoteViews) {

        int resId = getResources().getIdentifier("layout_remote_view", "layout", getPackageName());

        View view = LayoutInflater.from(this).inflate(resId, mRemoteViewContent);

        remoteViews.apply(this, mRemoteViewContent);
        mRemoteViewContent.addView(view);
    }
}
