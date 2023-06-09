package com.example.asm_andrnangcao_ps19353.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_andrnangcao_ps19353.R;
import com.example.asm_andrnangcao_ps19353.model.MonHoc;

import java.util.ArrayList;

public class DangKyMonHocAdapter extends RecyclerView.Adapter<DangKyMonHocAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MonHoc> list;

    public DangKyMonHocAdapter(Context context, ArrayList<MonHoc> list) {
        this.context = context;
        this.list = list;
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

        if(list.get(position).getIsRehidter()>0){
            holder.btnDangky.setText("hủy đăng k môn học");
            holder.btnDangky.setBackgroundColor(Color.RED);
            holder.btnDangky.setTextColor(Color.WHITE);
        }else {
            holder.btnDangky.setText("dang ký môn học thành công");
            holder.btnDangky.setBackgroundColor(Color.BLUE);
            holder.btnDangky.setTextColor(Color.WHITE);
        }
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
