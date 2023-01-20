package com.tubes.tubes;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.tubes.tubes.View.Info.InfoActivity;
import com.tubes.tubes.View.Mahasiswa.MahasiswaActivity;
import com.tubes.tubes.View.Mentor.MentorActivity;
import com.tubes.tubes.View.Topik.TopikActivity;
import com.tubes.tubes.View.Bimbingan.BimbinganActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static MahasiswaActivity ma;
    private Button btn_mhs;
    private Button btn_men;
    private Button btn_tb;
    private Button btn_bimbingan;
    private ImageButton btn_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_mhs = (Button) findViewById(R.id.btn_mhs);
        btn_mhs.setOnClickListener(this);
        btn_men = (Button) findViewById(R.id.btn_men);
        btn_men.setOnClickListener(this);

        btn_tb = (Button) findViewById(R.id.btn_tb);
        btn_tb.setOnClickListener(this);
        btn_bimbingan = (Button) findViewById(R.id.btn_bimbingan);
        btn_bimbingan.setOnClickListener(this);
        btn_info = (ImageButton) findViewById(R.id.btn_info);
        btn_info.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_mhs:
                Intent i = new Intent(this, MahasiswaActivity.class);
                startActivity(i);
                break;
            case R.id.btn_men:
                Intent i2 = new Intent(this, MentorActivity.class);
                startActivity(i2);
                break;
            case R.id.btn_tb:
                Intent i3 = new Intent(this, TopikActivity.class);
                startActivity(i3);
                break;
            case R.id.btn_bimbingan:
                Intent i4 = new Intent(this, BimbinganActivity.class);
                startActivity(i4);
                break;
            case R.id.btn_info:
                Intent i5 = new Intent(this, InfoActivity.class);
                startActivity(i5);
                break;

        }
    }
}