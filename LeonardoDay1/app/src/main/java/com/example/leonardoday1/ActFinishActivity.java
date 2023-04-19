package com.example.leonardoday1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActFinishActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_finish);

        findViewById(R.id.jumpToMain).setOnClickListener(this);
        TextView tv = findViewById(R.id.act_tv);
        tv.setTextSize(40);
        //  获取数据
        Bundle bundle = getIntent().getExtras();
        String value = bundle.getString("params");
        tv.setText(value);
        Log.e("Fibonacci", "onCreate: "+value);




    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.jumpToMain){
//            Intent intent = new Intent(this, MainActivity.class);
//
//            startActivity(intent);
            // 反回信息给上个界面
            Intent intent = getIntent();
            Bundle bundle = new Bundle();
            bundle.putString("params","i have receive your message");
            intent.putExtras(bundle);
            setResult(Activity.RESULT_OK,intent);
            // 返回上个界面
            finish();
        }
    }
}

