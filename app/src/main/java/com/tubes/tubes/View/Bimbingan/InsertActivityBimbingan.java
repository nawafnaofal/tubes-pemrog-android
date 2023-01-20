package com.tubes.tubes.View.Bimbingan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tubes.tubes.MainActivity;
import com.tubes.tubes.Model.Bimbingan.PostPutDelBimbingan;
import com.tubes.tubes.R;
import com.tubes.tubes.Rest.ApiClient;
import com.tubes.tubes.Rest.Interface.BimbinganInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivityBimbingan extends AppCompatActivity {
    EditText edtIdMahasiswa, edtIdMentor, edtIdTopik, edtWaktu;
    Button btInsert, btBack;
    BimbinganInterface mBimbinganInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bimbingan);
        edtIdMahasiswa = (EditText) findViewById(R.id.edtNamaBimbingan);
        edtIdMentor = (EditText) findViewById(R.id.edtMentorBimbingan);
        edtIdTopik = (EditText) findViewById(R.id.edtJudulBimbingan);
        edtWaktu = (EditText) findViewById(R.id.edtWaktuBimbingan);
        mBimbinganInterface = ApiClient.getClient().create(BimbinganInterface.class);
        btInsert = (Button) findViewById(R.id.btn_add);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelBimbingan> postBimbinganCall = mBimbinganInterface.postBimbingan(edtIdMahasiswa.getText().toString(), edtIdMentor.getText().toString(), edtIdTopik.getText().toString(), edtWaktu.getText().toString());
                postBimbinganCall.enqueue(new Callback<PostPutDelBimbingan>() {
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

        btBack = (Button) findViewById(R.id.btn_back);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });
    }
}
