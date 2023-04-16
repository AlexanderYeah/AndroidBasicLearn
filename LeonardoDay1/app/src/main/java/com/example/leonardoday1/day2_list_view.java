//package com.example.leonardoday1;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    List<Bean> datas = new ArrayList<>();
//
//    private static final String TAG = "Leonardo";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//
//        for (int i = 0; i < 100; i++) {
//            Bean bean = new Bean("ok i find you" + i);
//            datas.add(bean);
//        }
//
//        ListView lv = findViewById(R.id.lv);
//        // 配置数据
//        lv.setAdapter(new MyAdapter(this,datas));
//        // 点击监听
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.e(TAG, "onItemClick: ");
//            }
//        });
//
//    }
//
//}