package com.example.asm_andrnangcao_ps19353.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.asm_andrnangcao_ps19353.R;
import com.example.asm_andrnangcao_ps19353.adapter.DangKyMonHocAdapter;
import com.example.asm_andrnangcao_ps19353.model.MonHoc;
import com.example.asm_andrnangcao_ps19353.service.DangKyMonHocService;

import java.util.ArrayList;

public class DangKy extends AppCompatActivity {

    RecyclerView rcvdangky;
    int id;
    ArrayList<MonHoc> list;
    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        RecyclerView rcvdangky= (RecyclerView) findViewById(R.id.rcvdangky);
        intentFilter = new IntentFilter();
        intentFilter.addAction("DSMonHoc");

        //id nguoi dung dang nhap
        SharedPreferences sharedPreferences=getSharedPreferences("THONGTIN",MODE_PRIVATE);
        int id=sharedPreferences.getInt("id",-1);


        Intent intent=new Intent(DangKy.this, DangKyMonHocService.class);
        Bundle bundle=new Bundle();
        bundle.putInt("id",id);
        intent.putExtras(bundle);

        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myBroadcast,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myBroadcast);
    }

    private void loadDaTa(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvdangky.setLayoutManager(linearLayoutManager);
        DangKyMonHocAdapter adapter= new DangKyMonHocAdapter(this,list);
    }
    private BroadcastReceiver myBroadcast = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            switch (intent.getAction()) {
                case "DSMonHoc":
                    Bundle bundle=intent.getExtras();
                    list= (ArrayList<MonHoc>) bundle.getSerializable("list");
                    loadDaTa();
                    break;
            }

        }
    };
}