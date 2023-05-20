package com.example.asm_andrnangcao_ps19353;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Manhinhchao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchao);

        ImageView ivLogo = (ImageView) findViewById(R.id.ivLogo);

        //import thư viện để sử dụng gif
        Glide.with(this).load(R.mipmap.splash).into(ivLogo);
        //dùng để cho phép màn hình tồn tại trong 4s sau đó chuyển màn hình khác
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Manhinhchao.this, LoginActivity.class));
            }
        }, 4000);
    }
}