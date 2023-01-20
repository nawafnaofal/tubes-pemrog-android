package com.tubes.tubes.View.Bimbingan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tubes.tubes.MainActivity;
import com.tubes.tubes.Model.Bimbingan.PostPutDelBimbingan;
import com.tubes.tubes.Model.Mahasiswa.PostPutDelMahasiswa;
import com.tubes.tubes.R;
import com.tubes.tubes.Rest.ApiClient;
import com.tubes.tubes.Rest.Interface.BimbinganInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivityBimbingan extends AppCompatActivity {

    EditText  edtId ,edtIdMahasiswa, edtIdMentor, edtIdTopik, edtWaktu;
    Button btUpdate, btDelete, btBack;
    BimbinganInterface mBimbinganInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bimbingan);
        edtId = (EditText) findViewById(R.id.edtIdBimbinganEdit);
        edtIdMahasiswa = (EditText) findViewById(R.id.edtNamaBimbinganEdit);
        edtIdMentor = (EditText) findViewById(R.id.edtMentorBimbinganEdit);
        edtIdTopik = (EditText) findViewById(R.id.edtJudulBimbinganEdit);
        edtWaktu = (EditText) findViewById(R.id.edtWaktuBimbinganEdit);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id_bimbingan"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtIdMahasiswa.setText(mIntent.getStringExtra("Id_mahasiswa"));
        edtIdMentor.setText(mIntent.getStringExtra("Id_mentor"));
        edtIdTopik.setText(mIntent.getStringExtra("Id_topik"));
        edtWaktu.setText(mIntent.getStringExtra("waktu"));
        mBimbinganInterface = ApiClient.getClient().create(BimbinganInterface.class);
        btUpdate = (Button) findViewById(R.id.btn_add);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelBimbingan> updateBimbinganCall = mBimbinganInterface.putBimbingan(
                        edtId.getText().toString(),
                        edtIdMahasiswa.getText().toString(),
                        edtIdMentor.getText().toString(),
                        edtIdTopik.getText().toString(),
                        edtWaktu.getText().toString());
                updateBimbinganCall.enqueue(new Callback<PostPutDelBimbingan>() {
                    @Override
                    public void onResponse(Call<PostPutDelBimbingan> call, Response<PostPutDelBimbingan> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelBimbingan> call, Throwable t) {
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
                    Call<PostPutDelBimbingan> deleteBimbingan = mBimbinganInterface.deleteBimbingan(edtId.getText().toString());
                    deleteBimbingan.enqueue(new Callback<PostPutDelBimbingan>() {
                        @Override
                        public void onResponse(Call<PostPutDelBimbingan> call, Response<PostPutDelBimbingan> response) {
                            MainActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelBimbingan> call, Throwable t) {
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
