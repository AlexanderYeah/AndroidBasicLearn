//package com.example.leonardoday1;
//
//import android.app.Activity;
//import android.content.ComponentName;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.activity.result.ActivityResult;
//import androidx.activity.result.ActivityResultCallback;
//import androidx.activity.result.ActivityResultLauncher;
//import androidx.activity.result.contract.ActivityResultContracts;
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.net.URI;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private static final String TAG = "Fibonacci";
//    private ActivityResultLauncher<Intent> register;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        findViewById(R.id.send_next_msg).setOnClickListener(this);
//        TextView tv = findViewById(R.id.main_tv);
//
//        //
//        String string_name =  getString(R.string.myName);
//        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//            @Override
//            public void onActivityResult(ActivityResult result) {
//                if (result != null){
//                    Intent intent = result.getData();
//                    if (intent != null && result.getResultCode() == Activity.RESULT_OK){
//                        // 获取返回的数据
//                        Bundle bundle = intent.getExtras();
//                        String string = bundle.getString("params");
//                        tv.setText(string);
//                        Log.e(TAG, "onActivityResult: " + string);
//                    }
//                }
//            }
//        });
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()){
//
//            case R.id.send_next_msg:
//            {
//                Intent intent = new Intent(MainActivity.this,ActFinishActivity.class);
//                // 传递信息到下个界面 通过bundle 包装数据
//                Bundle bundle = new Bundle();
//                bundle.putString("params","go on my lady");
//                intent.putExtras(bundle);
//                register.launch(intent);
//            }
//            break;
//
//            default:
//                throw new IllegalStateException("Unexpected value: " + view.getId());
//        }
//
//
//    }
//}