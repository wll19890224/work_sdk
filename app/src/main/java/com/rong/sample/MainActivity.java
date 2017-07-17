package com.rong.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rongcapital.sdk.ui.RongSdk;
import com.rongcapital.sdk.ui.util.DateUtils;

public class MainActivity extends AppCompatActivity {
    String customerNo = ""; // 请使用下发的客户号
    String operator = "";   // 操作员号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.pay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RongSdk.receipt(MainActivity.this, "青橙科技订单", "健身房费用", DateUtils.getCurrentDataString(), 1L,
                    customerNo, operator);
            }
        });
    }

}
