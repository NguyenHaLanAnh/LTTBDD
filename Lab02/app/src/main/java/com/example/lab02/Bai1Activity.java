package com.example.lab02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai1Activity extends AppCompatActivity {

    Button btn_TinhLuong, btn_LamMoi, btn_KetThuc;
    EditText edNgayCong, edLuongNgay;
    TextView txtLuongThang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_TinhLuong = findViewById(R.id.btn_TinhLuong);
        btn_LamMoi = findViewById(R.id.btn_LamMoi);
        btn_KetThuc = findViewById(R.id.btn_KetThuc);
        edNgayCong = findViewById(R.id.edNgayCong);
        edLuongNgay = findViewById(R.id.edLuongNgay);
        txtLuongThang = findViewById(R.id.txtLuongThang);

        btn_TinhLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soNgay = Integer.parseInt(edNgayCong.getText().toString().trim());
                int luongNgay = Integer.parseInt(edLuongNgay.getText().toString().trim());
                int ketQua = soNgay * luongNgay;
                txtLuongThang.setText("Lương tháng là: " + ketQua);
            }
        });
        btn_LamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edNgayCong.setText("");
                edLuongNgay.setText("");
                txtLuongThang.setText("Lương tháng là:");
            }
        });
        btn_KetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                Intent intent = new Intent(Bai1Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}