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

public class Bai3Activity extends AppCompatActivity {
    Button btn_Tinh, btn_LamMoi, btn_KetThuc;
    EditText edBanKinh;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_Tinh = findViewById(R.id.btn_Tinh);
        btn_LamMoi = findViewById(R.id.btn_LamMoi);
        btn_KetThuc = findViewById(R.id.btn_KetThuc);
        edBanKinh = findViewById(R.id.edBanKinh);
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
                edBanKinh.setText("");
                txtKetQua.setText("Diện tích:    - Chu vi:");
            }
        });
        btn_KetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai3Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void tinhChuViDienTich() {
        String banKinhStr = edBanKinh.getText().toString().trim();
        if (!banKinhStr.isEmpty()) {
            double banKinh = Double.parseDouble(banKinhStr);
            double chuVi = 2 * Math.PI * banKinh;
            double dienTich = Math.PI * banKinh * banKinh;
            txtKetQua.setText("Chu vi: " + chuVi + "\nDiện tích: " + dienTich);
        } else {
            txtKetQua.setText("Vui lòng nhập đầy đủ thông tin.");
        }
    }
}
