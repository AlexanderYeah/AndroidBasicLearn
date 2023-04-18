package com.example.leonardoday1;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Fibonacci";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.jump_to_tel).setOnClickListener(this);
        findViewById(R.id.jump_to_sms).setOnClickListener(this);
        findViewById(R.id.jump_to_my_self).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.jump_to_tel:
            {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:123456789");
                intent.setData(uri);
                startActivity(intent);
            }
                break;
            case R.id.jump_to_sms:
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_SENDTO);
                // 123456789 为发送目标
                Uri uri2 = Uri.parse("sms:123456789");
                intent2.setData(uri2);
                startActivity(intent2);
                break;
            // 跳转我自己的页面
            case R.id.jump_to_my_self:
                Intent intent3 = new Intent();
                intent3.setAction("android.intent.action.myselfActivity");
                intent3.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent3);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }


    }
}