package com.example.leonardoday1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Fibonacci";
    private SQLiteDatabase db;
    String tableName = "student_table";

    private static MySQLiteOpenHelper helper = null;   //单例






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.save_info).setOnClickListener(this);

        createTable();


    }

    void  loadData(){

        String[] names = {"abc","cde","efg"};
        int[] ages = {15,18,19};

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int age = ages[i];
            String sex = i / 2 == 0 ? "male" : "female";
            String grade = "1年级";
//            Student student = new Student(name,age,sex,grade);
//            Log.e(TAG, "loadData:"+student.grade);
//            // 插入数据库
//            insertStudentToTable(student);
        }
    }

    void createTable(){
        //创建数据库test.db
        // 1 创建数据库
        String dbPath =  getFilesDir() + "/test.db";
        Log.e(TAG, "onCreate:" + dbPath);
        db = openOrCreateDatabase(dbPath, Context.MODE_PRIVATE,null);


        Log.e(TAG, "createTable: " +  db.isOpen());

//        queryData("abc");
        // 2先删除已经存在的表
//        String deleteSql = "drop table if exists " + tableName + ";";
//        db.execSQL(deleteSql);
//        // 3 建表 添加字段
//        String createSql = " CREATE TABLE IF NOT EXISTS " + tableName + "("
//                + "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
//                + "username VARCHAR NOT NULL," + "age INTEGER NOT NULL,"
//                + "sex VARCHAR NOT NULL," + "grade VARCHAR NOT NULL" + ");";
//        db.execSQL(createSql);



    }

    // 插入一条数据

    void insertStudentToTable( Student student ){

//        ContentValues cv = new ContentValues();
//        Log.e(TAG, "insertStudentToTable: " + student.username );
//
//        cv.put("username",student.username);
//
//        cv.put("age",student.age);
//        cv.put("sex",student.sex);
//        cv.put("grade",student.grade);
//        // 只要能保证cv 是有内容搞得  第二个参数可以忽略
//        // 这里的result 不能是 -1, -1 则代表失败
//        long result =  db.insert(tableName,null,cv);
//        // insertStudentToTable: 添加数据成功6，6代表第6条
//        Log.e(TAG, "insertStudentToTable: " + "添加数据成功" + result );

    }

    // 查询数据
    void queryData(String condition){

        String sql = String.format("select rowid, _id,username,age,sex,grade " +
                " from %s where %s;", tableName, condition);
        Log.e(TAG, "queryData: " +  db);
        db.beginTransaction();
        //执行查询语句，该语句返回结果集的游标
//        Cursor cursor =  db.rawQuery(sql,null);
//
//        ArrayList<Student> results = new ArrayList<>();
//
//        // 循环取出游标的结果
//        while (cursor.moveToNext()){
//
//            Student stu = new Student(cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getString(4));
//            Log.e(TAG, "queryData: " +  stu.username);
//        }
//
//        cursor.close();


    }



    @Override
    public void onClick(View view) {
        // 新增一条数据
        if (view.getId() == R.id.save_info){

            helper = MySQLiteOpenHelper.getInstance(MainActivity.this, 1);
            helper.openWriteLink();

            Student stu = new Student();
            stu.name = "1231312312312";
            stu.age = 23;
            helper.insert(stu);

        }
    }
}