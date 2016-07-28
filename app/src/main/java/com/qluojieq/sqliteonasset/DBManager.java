package com.qluojieq.sqliteonasset;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by shiliushuo-1 on 16/7/28.
 */

public class DBManager {
    SQLiteDatabase db;
    public void update(Context context)
    {
        //得到数据库对象
        MySQLiteOpenHelper oh = new MySQLiteOpenHelper(context, "weather.db", null, 1);
        db = oh.getWritableDatabase();

        //修改西安的温度为36度
        db.execSQL("update weather set temp = ? where city = ?", new Object[]{36, "西安"});

        //关闭数据库
        db.close();
    }
    public void query(Context context)
    {
        //得到数据库对象
        MySQLiteOpenHelper oh = new MySQLiteOpenHelper(context, "weather.db", null, 1);
        db = oh.getWritableDatabase();

        //查询温度大于36的城市
        Cursor cursor = db.rawQuery("select * from weather where temp > ?",  new String[]{"36"});
        while(cursor.moveToNext())
        {
            String city = cursor.getString(cursor.getColumnIndex("city"));
            String temp = cursor.getString(cursor.getColumnIndex("temp"));
            String pm = cursor.getString(cursor.getColumnIndex("pm"));

            System.out.println(city + ";" + temp + ";" + pm);
        }

        //关闭数据库
        db.close();
    }

    public void delete(Context context)
    {
        //得到数据库对象
        MySQLiteOpenHelper oh = new MySQLiteOpenHelper(context, "weather.db", null, 1);
        db = oh.getWritableDatabase();

        //删除城市名为哈尔滨
        db.execSQL("delete from weather where city = ?", new Object[]{"哈尔滨"});

        //关闭数据库
        db.close();
    }
}
