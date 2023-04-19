package com.example.leonardoday1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Fibonacci";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.save_btn).setOnClickListener(this);

        SharedPreferences shared = getSharedPreferences("user_info",MODE_PRIVATE);
        // 直接读取数据
        String username = shared.getString("username","");
        Log.e(TAG, "onCreate: " + username);


    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.save_btn){
            // 保存信息到本地
            EditText et1 = findViewById(R.id.username);
            EditText et2 = findViewById(R.id.password);
            // MODE_PRIVATE 默认模式，指定该SharedPreferences数据只能被本应用程序读、写。
            SharedPreferences shared = getSharedPreferences("user_info", MODE_PRIVATE);
            // 1 存储数据 借助Editor
            SharedPreferences.Editor editor =  shared.edit();
            editor.putString("username",et1.getText().toString());
            editor.putString("password",et2.getText().toString());
            // 提交数据
            editor.commit();

        }
    }
}