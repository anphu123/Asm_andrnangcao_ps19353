package com.example.asm_andrnangcao_ps19353.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

   public DbHelper(Context context){
            super(context,"DANGKYMONHOC",null,1);
   }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       //bảng người dùng
       String dbNguoidung ="CREATE TABLE NGUOIDUNG(id integer primary key autoincrement,username text,password text, name text )";
       sqLiteDatabase.execSQL(dbNguoidung);

        //bảng môn học
       String dbMonHoc="CREATE TABLE MONHOC(code text primary key autoincrement,name text,teacher text)";
       sqLiteDatabase.execSQL(dbMonHoc);

       //bảng thông tin
       String dbThongTin = "CREATE TABLE THONGTIN(id integer primary key autoincrement,code text, address text)";
       sqLiteDatabase.execSQL(dbThongTin);

       //bảng đăng kí
        String dbDangKy = "CREATE TABLE DANGKY(id integer, code text)";
       sqLiteDatabase.execSQL(dbDangKy);


        //data người dùng
       String insNguoiDung="INSERT INTO NGUOIDUNG VALUES(1,'tridinh','123456','Trí Định'),(2,'minhtri','123abc123','Minh Trí')";
       sqLiteDatabase.execSQL(insNguoiDung);


        // data mon hoc
       String insMonHoc="INSERT INTO MONHOC VALUES('MOB201','Android Nâng Cao','Nguyễn Trí Định'),('MOB306','React Native','Trần Anh Hùng'),('MOB2041','Dự Án Mẫu','Nguyễn Trí Định')";
       sqLiteDatabase.execSQL(insMonHoc);


       // thông tin học từng môn
       String insThongTin ="INSERT INTO THONGTIN VALUES(1, 'MOB201', 'Ca 2 - 19/09/2022', 'T1011'),(2, 'MOB201', 'Ca 2 - 21/09/2022', 'T1011'),(3, 'MOB201', 'Ca 2 - 23/09/2022', 'T1011'),(4, 'MOB306', 'Ca 5 - 20/09/2022', 'F204'),(5, 'MOB306', 'Ca 5 - 22/09/2022', 'F204'),(6, 'MOB2041', 'Ca 1 - 20/09/2022', 'Online - https://meet.google.com/rku-beuk-wqu')";
       sqLiteDatabase.execSQL(insThongTin);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       if(i != i1) {
           sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
           sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MONHOC");
           sqLiteDatabase.execSQL("DROP TABLE IF EXISTS THONGTIN");
           sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DANGKY");
           onCreate(sqLiteDatabase);
       }

    }
}
