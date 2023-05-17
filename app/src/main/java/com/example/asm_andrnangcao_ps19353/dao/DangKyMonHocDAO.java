package com.example.asm_andrnangcao_ps19353.dao;

import android.content.Context;

import com.example.asm_andrnangcao_ps19353.helper.DbHelper;

public class DangKyMonHocDAO {
    private DbHelper dbHelper;
    public DangKyMonHocDAO(Context context) {
        dbHelper= new DbHelper(context);
        //lấy danh sách môn học

    }

}
