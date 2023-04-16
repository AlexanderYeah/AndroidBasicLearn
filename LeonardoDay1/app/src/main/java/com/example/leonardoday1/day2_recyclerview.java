//package com.example.leonardoday1;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.LinearLayout;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.StaggeredGridLayoutManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    private static final String TAG = "Leonardo";
//    private List<Bean> datas = new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        for (int i = 0; i < 100; i++) {
//            Bean bean;
//            if (i % 4 != 0){
//                bean = new Bean("ok i need u and you" + i);
//            }else{
//                bean = new Bean("ok ok BalaBalaBalauBalaBalaBalauok BBalaBalaBalauBalaBalaBalaualaBalaBalauBalaBalaBalau" + i);
//            }
//            datas.add(bean);
//        }
//
//        RecyclerView rv = findViewById(R.id.rv);
//        MyRecyclerAdapter adapter =  new MyRecyclerAdapter(datas,this);
//        // 设置adapter
//        rv.setAdapter(adapter);
//        // 设置布局
//        // 这里设置为线性的布局
////        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
////        rv.setLayoutManager(layoutManager);
//
//        // 网格布局
////         Context context,
////    int spanCount, 一行显示3个
////    int orientation,
////    boolean reverseLayout
////        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
////        rv.setLayoutManager(gridLayoutManager);
//
////         int spanCount, 一行几个
////    int orientation
//        // 瀑布流布局
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayout.VERTICAL);
//        rv.setLayoutManager(staggeredGridLayoutManager);
//
//        // 设置监听 自己实现的监听方法
//        adapter.setRecyclerItemClickListener(new MyRecyclerAdapter.OnRecyclerItemClickListener() {
//            @Override
//            public void onReceiveItemClick(int position) {
//                Log.e(TAG, "onReceiveItemClick: " + position);
//            }
//        });
//
//
//    }
//
//}