package com.example.asm_andrnangcao_ps19353.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm_andrnangcao_ps19353.helper.DbHelper;

public class NguoiDungDAO {
    DbHelper dbHelper;
    SharedPreferences sharedPreferences;

    public NguoiDungDAO(Context context) {
        dbHelper = new DbHelper(context);
        sharedPreferences= context.getSharedPreferences("THONGTIN",Context.MODE_PRIVATE);
    }

    public boolean kiemTraDangNhap(String user, String pass) {
        SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqliteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE username = ? AND password =?", new String[]{user, pass});
        if (cursor.getCount() != 0) {
            //lay va luu id nguoi dung de dang ky mon hoc
            cursor.moveToFirst();
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("id", cursor.getInt(0));
            editor.apply();

            return true;
        } else {
            return false;
        }

    }
}
