//package com.example.leonardoday1;
//
//import android.os.Bundle;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    private static final String TAG = "Leonardo";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        LinearLayout linearLayout = new LinearLayout(this);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        linearLayout.setLayoutParams(layoutParams);
//
//        TextView textView = new TextView(this);
//        textView.setText("Hello");
//        textView.setBackgroundColor(0xff00ff00);
//        // 这里的100 和  200 是像素
//        textView.setLayoutParams(new LinearLayout.LayoutParams(300,300));
//        linearLayout.addView(textView);
//
//        setContentView(linearLayout);
//
//
//    }
//
//}