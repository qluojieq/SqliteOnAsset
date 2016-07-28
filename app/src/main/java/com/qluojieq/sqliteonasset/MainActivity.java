package com.qluojieq.sqliteonasset;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(this,"testDb.db",null,1);
        mySQLiteOpenHelper.getWritableDatabase();
        query();

    }

    public void query()
    {
        //得到数据库对象
        MySQLiteOpenHelper oh = new MySQLiteOpenHelper(this, "weather.db", null, 1);
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
}
