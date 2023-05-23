package com.example.asm_andrnangcao_ps19353.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm_andrnangcao_ps19353.helper.DbHelper;
import com.example.asm_andrnangcao_ps19353.model.MonHoc;

import java.util.ArrayList;

public class DangKyMonHocDAO {
    private DbHelper dbHelper;

    public DangKyMonHocDAO(Context context) {
        dbHelper = new DbHelper(context);


    }

    //lấy danh sách môn học
    public ArrayList<MonHoc> getDSMonHoc(int id) {
        ArrayList<MonHoc> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT mh.code,mh.name,mh.teacher,dk.id FROM MONHOC mh LEFT JOIN DANGKY dk ON mh.code = dk.code AND dk.code=?", new String[]{String.valueOf(id)});
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new MonHoc(cursor.getString(0), cursor.getString(1), cursor.getString(2),cursor.getInt(3)));
            } while (cursor.moveToNext());
        }
        return list;
    }

}
