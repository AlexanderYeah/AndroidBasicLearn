//package com.example.leonardoday1;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.viewpager.widget.ViewPager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    private static final String TAG = "Fibonacci";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        LayoutInflater layoutInflater = getLayoutInflater().from(this);
//        View view1 = layoutInflater.inflate(R.layout.day3_layout1, null);
//        View view2 = layoutInflater.inflate(R.layout.day3_layout2, null);
//        View view3 = layoutInflater.inflate(R.layout.day3_layout3, null);
//
//        List<View> views = new ArrayList<>();
//        views.add(view1);
//        views.add(view2);
//        views.add(view3);
//
//        ViewPager vp = findViewById(R.id.vp);
//        // 设置adapter
//        vp.setAdapter(new MyViewPagerAdapter(views));
//
//
//    }
//
//}