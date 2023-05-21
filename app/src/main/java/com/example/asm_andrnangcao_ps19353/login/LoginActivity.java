package com.example.asm_andrnangcao_ps19353.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asm_andrnangcao_ps19353.R;
import com.example.asm_andrnangcao_ps19353.home.MainActivity;
import com.example.asm_andrnangcao_ps19353.service.KiemTraDangNhapService;

public class LoginActivity extends AppCompatActivity {

    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView imgLogin = (ImageView) findViewById(R.id.imgLogin);
        EditText edtUser = (EditText) findViewById(R.id.edtUser);
        EditText edtPass = (EditText) findViewById(R.id.edtPass);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        intentFilter = new IntentFilter();
        intentFilter.addAction("kiemTraDangNhap");

        Glide.with(this).load(R.mipmap.splash).into(imgLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();

                Intent intent = new Intent(LoginActivity.this, KiemTraDangNhapService.class);
                Bundle bundle = new Bundle();
                bundle.putString("user", user);
                bundle.putString("pass", pass);
                intent.putExtras(bundle);
                startService(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        registerReceiver(myBroadcast, intentFilter);
        super.onResume();
    }

    public BroadcastReceiver myBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case "kiemTraDangNhap":
                    Bundle bundle = intent.getExtras();
                    boolean check = bundle.getBoolean("check");
                    if (check) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    break;
            }
        }
    };
}