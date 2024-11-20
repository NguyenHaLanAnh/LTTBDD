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

public class Bai4Activity extends AppCompatActivity {
    Button btn_Tinh, btn_LamMoi, btn_KetThuc;
    EditText edSoNguyen;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_Tinh = findViewById(R.id.btn_Tinh);
        btn_LamMoi = findViewById(R.id.btn_LamMoi);
        btn_KetThuc = findViewById(R.id.btn_KetThuc);
        edSoNguyen = findViewById(R.id.edSoNguyen);
        txtKetQua = findViewById(R.id.txtKetQua);

        btn_Tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhTongCacChuSo();
            }
        });
        btn_LamMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edSoNguyen.setText("");
                txtKetQua.setText(getString(R.string.KetQua));
            }
        });
        btn_KetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai4Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void tinhTongCacChuSo() {
        String soNguyenStr = edSoNguyen.getText().toString().trim();
        if (!soNguyenStr.isEmpty()) {
            int soNguyen = Integer.parseInt(soNguyenStr);
            int tong = 0;
            while (soNguyen != 0) {
                tong += soNguyen % 10;
                soNguyen /= 10;
            }
            txtKetQua.setText(getString(R.string.KetQua) + " " + tong);
        } else {
            txtKetQua.setText("Vui lòng nhập đầy đủ thông tin.");
        }
    }
}
