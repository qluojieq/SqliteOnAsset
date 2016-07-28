package com.qluojieq.sqliteonasset;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shiliushuo-1 on 16/7/28.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {



    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table weather(_id integer primary key autoincrement, city char(10), temp integer(3), pm integer(5))");
        sqLiteDatabase.execSQL("insert into weather(city, temp, pm) values(?, ?, ?)", new Object[]{"北京",37,280});
        sqLiteDatabase.execSQL("insert into weather(city, temp, pm) values(?, ?, ?)", new Object[]{"西安",35,200});
        sqLiteDatabase.execSQL("insert into weather(city, temp, pm) values(?, ?, ?)", new Object[]{"上海",37,100});
        sqLiteDatabase.execSQL("insert into weather(city, temp, pm) values(?, ?, ?)", new Object[]{"哈尔滨",30,80});
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
