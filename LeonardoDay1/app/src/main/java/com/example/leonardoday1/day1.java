package com.example.leonardoday1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class day1 extends AppCompatActivity {

    private static final String TAG = "Leonardo";

    private ImageView imgView;
    private ProgressBar pb;

    private ProgressBar pb2;

    private NotificationManager manager;
    private Notification notification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button btn = findViewById(R.id.btn);
//        btn.setText("ClickOK");
//
//        imgView = findViewById(R.id.img_view);
//        imgView.setImageResource(R.drawable.demo2);
//
//        // 默认值 缩放后放置于中间
//        imgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//        // 最主要的目的是把图片显示在里面
//        imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//        // 不改变 原图的大小 从左上角开始绘制 ，超过的部分做剪裁处理
//        imgView.setScaleType(ImageView.ScaleType.MATRIX);
//        EditText et = findViewById(R.id.editText);
//
//        pb = findViewById(R.id.pb);
//        pb2 = findViewById(R.id.pb_h);


        // 点击事件
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 收到点击效果
////                String s =  et.getText().toString();
////                Log.e(TAG, "onClick: " + s);
//
//                if(pb.getVisibility() == View.GONE){
//                    pb.setVisibility(View.VISIBLE);
//                }else {
//                    pb.setVisibility(View.GONE);
//                }
//                int progress = pb2.getProgress();
//                progress += 10;
//                pb2.setProgress(progress);
//            }
//        });

        // 1 创建通知管理
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //2 创建一个通知 channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("leo","测试下",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }
        // 3 创建一个通知
        // 3.1 创建一个跳转的意图 点击通知进行跳转
        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent p_intent  = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // context
        notification = new NotificationCompat.Builder(this,"leo").setContentTitle("温馨提示")
                .setContentText("这是一个通知哦")
                .setSmallIcon(R.drawable.baseline_access_alarm_24)
                .setColor(Color.parseColor("#ff0000"))
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.demo2))
                .setContentIntent(p_intent)
                .setAutoCancel(true)
                .build();

        Button sendBtn = findViewById(R.id.send_noti);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 发送通知
                manager.notify(1,notification);
            }
        });

        Button cancelBtn = findViewById(R.id.cancel_noti);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 取消发送通知
                manager.cancel(1);
            }
        });

    }


    public void leoClick(View view) {
        Log.e(TAG, "leoClick " );

    }
}