package com.rong.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.rongcapital.sdk.ui.RongSdk;

import java.text.SimpleDateFormat;
import java.util.Date;

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
                RongSdk.receipt(MainActivity.this,
                    "青橙科技订单", "健身房费用",
                    new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()),
                    1L,
                    customerNo,
                    operator);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1001) {
            Log.d("main/", data.getStringExtra("data"));
        }
    }

}
