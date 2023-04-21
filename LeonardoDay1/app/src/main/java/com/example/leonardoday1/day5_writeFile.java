//package com.example.leonardoday1;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private static final String TAG = "Fibonacci";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        findViewById(R.id.save_btn).setOnClickListener(this);
//
//    }
//
//
//    @Override
//    public void onClick(View view) {
//        if (view.getId() == R.id.save_btn){
//            // 内部存储文件
//            String fileName = "myInputFile.txt";
//            String string = "doublekilhahahhah ";
//            FileOutputStream fos = null;
//            try {
//                fos = openFileOutput(fileName, Context.MODE_PRIVATE);
//                fos.write(string.getBytes());
//                fos.close();
//                Log.e(TAG, "onClick: "+"123123");
//            }catch (FileNotFoundException e){
//                e.printStackTrace();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//            // 获取files 文件夹的绝对路径
//            // /data/user/0/com.example.leonardoday1/files
////            Log.e(TAG, "onClick: " + getFilesDir());
////
////            // /data/user/0/com.example.leonardoday1/app_myInputFile.txt
////            String myFilePath = getDir(fileName, Context.MODE_PRIVATE).getAbsolutePath();
////            Log.e(TAG, "onClick: " + myFilePath);
////            // deleteFile 删除文件
////            // 这个地方传入目录
////            boolean isSuccess =  deleteFile(myFilePath);
////            Log.e(TAG, "onClick: " + isSuccess);
//
//
//
//        }
//    }
//}

//<LinearLayout
//    xmlns:android="http://schemas.android.com/apk/res/android"
//            android:layout_width="match_parent"
//            android:layout_height="match_parent"
//            android:orientation="vertical"
//            android:background="#ffffff"
//            android:gravity="center">
//
//
//<EditText
//        android:id="@+id/username"
//                android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:hint="请输入用户名"
//                />
//
//<EditText
//        android:id="@+id/password"
//                android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:hint="请输入密码"
//                />
//
//<Button
//        android:id="@+id/save_btn"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:text="保存用户名和密码到本地"/>
//
//
//</LinearLayout>
