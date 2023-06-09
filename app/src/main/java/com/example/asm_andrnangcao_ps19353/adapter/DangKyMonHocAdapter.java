package com.example.asm_andrnangcao_ps19353.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_andrnangcao_ps19353.R;
import com.example.asm_andrnangcao_ps19353.model.MonHoc;
import com.example.asm_andrnangcao_ps19353.service.DKMonHocService;

import java.util.ArrayList;

public class DangKyMonHocAdapter extends RecyclerView.Adapter<DangKyMonHocAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MonHoc> list;
    private int id;

    public DangKyMonHocAdapter(Context context, ArrayList<MonHoc> list, int id) {
        this.context = context;
        this.list = list;
        this.id= this.id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_dangky, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtCode.setText(String.valueOf(list.get(position).getCode()));
        holder.txtName.setText(list.get(position).getName());
        holder.txtTeacher.setText(list.get(position).getTeacher());

        if(list.get(position).getIsRehidter() == id){
            holder.btnDangky.setText("hủy đăng ký môn học");
            holder.btnDangky.setBackgroundColor(Color.RED);
            holder.btnDangky.setTextColor(Color.WHITE);
        }else {
            holder.btnDangky.setText("dang ký thành công");
            holder.btnDangky.setBackgroundColor(Color.BLUE);
            holder.btnDangky.setTextColor(Color.WHITE);
        }
        holder.btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DKMonHocService.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",id);
                bundle.putString("code",list.get(holder.getAdapterPosition()).getCode());

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtCode, txtName, txtTeacher;
        Button btnDangky;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txtCode = itemView.findViewById(R.id.txtCode);
            txtName = itemView.findViewById(R.id.txtName);
            txtTeacher = itemView.findViewById(R.id.txtTeacher);
            btnDangky = itemView.findViewById(R.id.btnDangky);
        }
    }
    //   private  void showDialog(ArrayList<Thongtin>){
    //
    //   }

}
