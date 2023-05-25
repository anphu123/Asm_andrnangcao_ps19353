package com.example.asm_andrnangcao_ps19353.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asm_andrnangcao_ps19353.login.LoginActivity;
import com.example.asm_andrnangcao_ps19353.R;
import com.example.asm_andrnangcao_ps19353.course.CourseActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgCourse = (ImageView) findViewById(R.id.imgCourse);
        ImageView imgMap = (ImageView) findViewById(R.id.imgMap);
        ImageView imgNews = (ImageView) findViewById(R.id.imgNews);
        ImageView imgSocial = (ImageView) findViewById(R.id.imgSocial);




        imgMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
        imgNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });
        imgSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SocialActivity.class);
                startActivity(intent);
            }
        });

        imgCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseActivity.class);
                startActivity(intent);
            }
        });


    }
}