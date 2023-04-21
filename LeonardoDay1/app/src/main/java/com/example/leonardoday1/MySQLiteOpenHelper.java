package com.example.leonardoday1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "test.db";   //数据库名称
    private static final int DB_VERSION = 1;   //数据库的版本号
    private static MySQLiteOpenHelper helper = null;   //单例
    private SQLiteDatabase sdb = null;  //数据库实例
    public static final String TABLE_NAME = "user_info";   //表名

    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    public MySQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public MySQLiteOpenHelper(Context context, int version) {
        super(context, DB_NAME, null, version);
    }

    //通过单例模式获取 UserDBHelper 的唯一实例
    public static synchronized MySQLiteOpenHelper getInstance(Context context, int version) {
        if (version > 0 && helper == null) {
            helper = new MySQLiteOpenHelper(context, version);
        } else if (helper == null) {
            helper = new MySQLiteOpenHelper(context);
        }

        return helper;
    }

    //打开读连接
    public SQLiteDatabase openReadLink() {
        if (sdb == null || !sdb.isOpen()) {
            sdb = helper.getReadableDatabase();
        }
        return sdb;
    }

    //打开写连接
    public SQLiteDatabase openWriteLink() {
        if (sdb == null || !sdb.isOpen()) {
            sdb = helper.getWritableDatabase();
        }

        return sdb;
    }

    //关闭数据库连接
    public void closeLink() {
        if (sdb != null && sdb.isOpen()) {
            sdb.close();
            sdb = null;
        }
    }

    //创建数据库，执行建表语句
    @Override
    public void onCreate(SQLiteDatabase db) {
        //先删除已存在表
        String drop_sql = "drop table if exists " + TABLE_NAME + ";";
        db.execSQL(drop_sql);

        //创建表
        String create_sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + "name VARCHAR NOT NULL," + "age INTEGER NOT NULL"
                //演示数据库升级时要先把下面这行注释
//                + ",phone VARCHAR" + ",password VARCHAR"
                + ");";

        db.execSQL(create_sql);
    }

    //修改表结构
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > 1) {
            //Android的ALTER命令不支持一次添加多列，只能分多次添加
            String alter_sql = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN phone VARCHAR;";
            db.execSQL(alter_sql);

            alter_sql = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + "password VARCHAR;";
            db.execSQL(alter_sql); // 执行完整的SQL语
        }
    }

    //根据指定条件删除记录
    public int delete(String condition) {
        return sdb.delete(TABLE_NAME, condition, null);
    }

    //删除全部记录
    public int deleteAll() {
        return sdb.delete(TABLE_NAME, "1=1", null);
    }

    //根据条件查询记录
    public List<Student> query(String condition) {
        String sql = String.format("select rowid,_id,name,age" +
                " from %s where %s;", TABLE_NAME, condition);
        //执行查询语句，该语句返回结果集的游标
        Cursor cursor = sdb.rawQuery(sql, null);

        ArrayList<Student> userInfos = new ArrayList<>();

        //循环取出游标指向的结果集
        while (cursor.moveToNext()) {
            Student stu = new Student();
            stu.name = cursor.getString(2);
            stu.age = cursor.getInt(3);
            userInfos.add(stu);
        }

        cursor.close();
        return userInfos;
    }

    //往表里添加一条记录
    public long insert(Student userinfo) {
        ArrayList<Student> userInfos = new ArrayList<>();
        userInfos.add(userinfo);
        return insert(userInfos);
    }

    //往表里添加多条记录
    public long insert(List<Student> userInfos) {

        long result = -1;

        for (Student userInfo : userInfos) {
            //如果名字相同，则更新记录
            if (userInfo.name != null && userInfo.name.length() > 0) {
                String condition = String.format("name = '%s'", userInfo.name);
                List<Student> dbUserInfoList = query(condition);
                if (dbUserInfoList != null && dbUserInfoList.size() > 0) {
                    update(userInfo, condition);
                    //返回其id
                    result = dbUserInfoList.get(0).age;
                    continue;
                }
            }
            //其余情况则说明记录不重复，添加新纪录
            ContentValues cv = new ContentValues();
            cv.put("name", userInfo.name);
            cv.put("age", userInfo.age);
            result = sdb.insert(TABLE_NAME, "", cv);
            if(result == -1){
                return result;
            }
            Log.e("Fibonacci", "insert: " + result);
        }

        return result;
    }

    //根据指定条件更新表记录
    public int update(Student userInfo, String condition) {

        ContentValues cv = new ContentValues();
        cv.put("name", userInfo.name);
        cv.put("age", userInfo.age);

        return sdb.update(TABLE_NAME, cv, condition, null);
    }


}
