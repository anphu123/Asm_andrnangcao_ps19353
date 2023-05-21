package com.example.asm_andrnangcao_ps19353.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.asm_andrnangcao_ps19353.home.MainActivity;
import com.example.asm_andrnangcao_ps19353.R;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        LinearLayout lnCourses = (LinearLayout) findViewById(R.id.lnCourses);
        LinearLayout lnCourse1 = (LinearLayout) findViewById(R.id.lnCourses1);
        Button btnbackcourse = (Button) findViewById(R.id.btnbackcourse);

        btnbackcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(CourseActivity.this, MainActivity.class);
               startActivity(intent);
            }
        });


        lnCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this, DangKy.class);
                startActivity(intent);
            }
        });
        lnCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this, DangKy1.class);
                startActivity(intent);
            }
        });
    }
}