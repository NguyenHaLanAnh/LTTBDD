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

public class Bai2Activity extends AppCompatActivity {
    Button btn_Tinh, btn_LamMoi, btn_KetThuc;
    EditText edChieuDai, edChieuRong;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_Tinh = findViewById(R.id.btn_Tinh);
        btn_LamMoi = findViewById(R.id.btn_LamMoi);
        btn_KetThuc = findViewById(R.id.btn_KetThuc);
        edChieuDai = findViewById(R.id.edChieuDai);
        edChieuRong = findViewById(R.id.edChieuRong);
        txtKetQua = findViewById(R.id.txtKetQua);

        btn_Tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhChuViDienTich();
            }
        });
        btn_LamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edChieuDai.setText("");
                edChieuRong.setText("");
                txtKetQua.setText("Diện tích:    - Chu vi:");
            }
        });
        btn_KetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void tinhChuViDienTich() {
        String chieuDaiStr = edChieuDai.getText().toString().trim();
        String chieuRongStr = edChieuRong.getText().toString().trim();
        if (!chieuDaiStr.isEmpty() && !chieuRongStr.isEmpty()) {
            int chieuDai = Integer.parseInt(chieuDaiStr);
            int chieuRong = Integer.parseInt(chieuRongStr);
            int chuVi = 2 * (chieuDai + chieuRong);
            int dienTich = chieuDai * chieuRong;
            txtKetQua.setText("Chu vi: " + chuVi + "\nDiện tích: " + dienTich);
        } else {
            txtKetQua.setText("Vui lòng nhập đầy đủ thông tin.");
        }
    }
}
