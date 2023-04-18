package com.example.leonardoday1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActFinishActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_finish);

        findViewById(R.id.jumpToMain).setOnClickListener(this);
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

        if (view.getId() == R.id.jump_to_tel){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
    }
}

