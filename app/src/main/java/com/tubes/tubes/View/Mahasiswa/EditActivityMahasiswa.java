package com.tubes.tubes.View.Mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tubes.tubes.MainActivity;
import com.tubes.tubes.Model.Mahasiswa.PostPutDelMahasiswa;
import com.tubes.tubes.R;
import com.tubes.tubes.Rest.ApiClient;
import com.tubes.tubes.Rest.Interface.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivityMahasiswa extends AppCompatActivity {
    EditText  edtId ,edtNama, edtNpm, edtJurusan;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mhs);
        edtId = (EditText) findViewById(R.id.edtIdMhsEdit);
        edtNama = (EditText) findViewById(R.id.edtNamaMhsEdit);
        edtNpm = (EditText) findViewById(R.id.edtNpmEdit);
        edtJurusan = (EditText) findViewById(R.id.edtJurusanEdit);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id_mahasiswa"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edtNpm.setText(mIntent.getStringExtra("Npm"));
        edtJurusan.setText(mIntent.getStringExtra("Jurusan"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btn_add);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelMahasiswa> updateMahasiswaCall = mApiInterface.putMahasiswa(
                        edtId.getText().toString(),
                        edtNama.getText().toString(),
                        edtNpm.getText().toString(),
                        edtJurusan.getText().toString());
                updateMahasiswaCall.enqueue(new Callback<PostPutDelMahasiswa>() {
                    @Override
                    public void onResponse(Call<PostPutDelMahasiswa> call, Response<PostPutDelMahasiswa> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelMahasiswa> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btDelete = (Button) findViewById(R.id.btn_back);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelMahasiswa> deleteMahasiswa = mApiInterface.deleteMahasiswa(edtId.getText().toString());
                    deleteMahasiswa.enqueue(new Callback<PostPutDelMahasiswa>() {
                        @Override
                        public void onResponse(Call<PostPutDelMahasiswa> call, Response<PostPutDelMahasiswa> response) {
                            MainActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelMahasiswa> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
//        btBack = (Button) findViewById(R.id.btBackGo);
//        btBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.ma.refresh();
//                finish();
//            }
//        });
    }
}
