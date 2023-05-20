package com.example.asm_andrnangcao_ps19353;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Manhinhchao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchao);

        ImageView ivLogo = (ImageView) findViewById(R.id.ivLogo);


        Glide.with(this).load(R.mipmap.splash).into(ivLogo);
    }
}