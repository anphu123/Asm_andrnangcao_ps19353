package com.example.asm_andrnangcao_ps19353.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm_andrnangcao_ps19353.helper.DbHelper;

public class NguoiDungDAO {
    DbHelper dbHelper;

    public NguoiDungDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public boolean kiemTraDangNhap(String user, String pass) {
        SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE username = ? AND password =?", new String[]{user, pass});
        if (cursor.getCount() != 0) {
            return true;
        } else {
            return false;
        }

    }
}
