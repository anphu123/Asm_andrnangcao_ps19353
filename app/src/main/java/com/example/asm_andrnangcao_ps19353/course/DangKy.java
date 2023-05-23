package com.example.asm_andrnangcao_ps19353.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.asm_andrnangcao_ps19353.R;

public class DangKy extends AppCompatActivity {

    RecyclerView rcvdangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        RecyclerView rcvdangky= (RecyclerView) findViewById(R.id.rcvdangky);




    }
}