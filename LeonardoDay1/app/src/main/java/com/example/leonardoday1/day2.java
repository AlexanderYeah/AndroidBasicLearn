//package com.example.leonardoday1;
//
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.PopupWindow;
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//
//public class day2 extends AppCompatActivity  {
//
//    private static final String TAG = "Leonardo";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar tb =  findViewById(R.id.tb);
//        tb.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        Button btn_alert =  findViewById(R.id.btn_alert);
//        btn_alert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                showAlertDialog();
//                showPopWindow(view);
//
//            }
//        });
//
//
//    }
//    void showPopWindow(View view){
//        // 在实际开发中LayoutInflater这个类还是非常有用的，它的作用类似于findViewById()。
//        // 不同点是LayoutInflater是用来找res/layout/下的xml布局文件，并且实例化；而findViewById()是找xml布局文件下的具体widget控件(如Button、TextView等)。
//        View popView = getLayoutInflater().inflate(R.layout.popup,null);
//
//        // focusable 最后的一个参数 点击空白处可以退出
//        PopupWindow popUpWindow = new PopupWindow(popView, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
//        // 后面两个参数为宽高
//        //显示在view 的下方 后面两个参数为X Y 轴的偏移
//        popUpWindow.showAsDropDown(view,90,20);
//
//        // 按钮的监听
//        Button btn1 =  popView.findViewById(R.id.pop_btn_1);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 消失
//                popUpWindow.dismiss();
//            }
//        });
//        Button btn2 =  popView.findViewById(R.id.pop_btn_2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 消失
//                popUpWindow.dismiss();
//            }
//        });
//    }
//
//
//    // 显示对话框
//    void showAlertDialog(){
//        // 弹出对话框
//        // 1构造器
//        AlertDialog.Builder  dialog = new AlertDialog.Builder(MainActivity.this);
//        // 设置内容
//        dialog.setTitle("This is My oscillator")
//                .setMessage("Something I know")
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        // 确认的点击
//
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//
//        // 显示
//        dialog.show();
//    }
//}
