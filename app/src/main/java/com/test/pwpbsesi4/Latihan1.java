package com.test.pwpbsesi4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Latihan1 extends AppCompatActivity {
    EditText angka1;
    EditText angka2;
    EditText hasil;
    Button btn_hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan1);

        initUI();
        initEvent();
    }

    private void initUI(){
        angka1 = findViewById(R.id.txt_angka1);
        angka2 = findViewById(R.id.txt_angka2);
        hasil = findViewById(R.id.txt_angkahasil);
        btn_hasil = findViewById(R.id.btnHasil);
    }

    private void initEvent(){
        btn_hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitungHasil();
            }
        });
    }

    private void hitungHasil(){
        int num1 = Integer.parseInt(angka1.getText().toString());
        int num2 = Integer.parseInt(angka2.getText().toString());
        int hasil_jumlah = num1+num2;
        hasil.setText(hasil_jumlah+"");
    }
}
