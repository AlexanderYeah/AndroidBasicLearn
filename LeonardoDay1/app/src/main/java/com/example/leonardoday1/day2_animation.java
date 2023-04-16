//package com.example.leonardoday1;
//
//import android.animation.Animator;
//import android.animation.AnimatorListenerAdapter;
//import android.animation.ObjectAnimator;
//import android.animation.ValueAnimator;
//import android.graphics.drawable.AnimatedImageDrawable;
//import android.graphics.drawable.AnimationDrawable;
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class MainActivity extends AppCompatActivity {
//
//    private static final String TAG = "Fibonacci";
//    private  boolean flag = true;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        animaterDemo();
//        objAnimatorDemo();
//
//    }
//
//
//    void  objAnimatorDemo(){
//        ImageView imgv = findViewById(R.id.img_v);
//        imgv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 透明度动画
//                ObjectAnimator animator1 = ObjectAnimator.ofFloat(imgv, "alpha", 0f, 1f);
//                // 旋转动画
//                ObjectAnimator animator2 = ObjectAnimator.ofFloat(imgv, "rotation", 0, 180);
//                // 平移动画
//                ObjectAnimator animator3 = ObjectAnimator.ofFloat(imgv, "translationX", 0, 100);
//                animator3.setDuration(4000);
//                animator3.start();
//
//                // 适配的方式监听动画回调完成
//                animator2.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//                    }
//                });
//
//                // 监听器，也可以采用适配的方式选择自己需要重写的方法
//                animator3.addListener(new Animator.AnimatorListener() {
//                    // 开始的时候调用此方法
//                    @Override
//                    public void onAnimationStart(@NonNull Animator animator) {
//
//                    }
//                    // 动画结束的时候调用此方法
//                    @Override
//                    public void onAnimationEnd(@NonNull Animator animator) {
//
//                    }
//                    // 取消动画的时候调用此方法
//                    @Override
//                    public void onAnimationCancel(@NonNull Animator animator) {
//
//                    }
//                    // 重复执行的时候调用此方法
//                    @Override
//                    public void onAnimationRepeat(@NonNull Animator animator) {
//
//                    }
//                });
//            }
//        });
//    }
//
//    void  animaterDemo(){
//        // 创建
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 2f);
//        // 3秒时间完成
//        valueAnimator.setDuration(3000);
//        // 监听
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(@NonNull ValueAnimator animator) {
//                float value = (float) animator.getAnimatedValue();
//                Log.e(TAG, "onAnimationUpdate: " + value);
//            }
//        });
//        // 开启
//        valueAnimator.start();
//
//    }
//
//    void  animationDemo(){
//        ImageView imgv = findViewById(R.id.img_v);
//        // 获取backgroundAnimationDrawable background =(AnimationDrawable) imgv.getBackground();
//
//        imgv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 通过加载XML 动画设置文件创建一个动画
//                Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
//                // 开启动画
//                imgv.startAnimation(animation1);
//                Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
//                imgv.startAnimation(animation2);
//                Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale);
//                imgv.startAnimation(animation3);
//                Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate);
//                imgv.startAnimation(animation4);
//
//
//
//
//            }
//        });
//    }
//
//}