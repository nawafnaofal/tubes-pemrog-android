package com.tubes.tubes.View.Topik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tubes.tubes.MainActivity;
import com.tubes.tubes.Model.Topik.PostPutDelTopik;
import com.tubes.tubes.R;
import com.tubes.tubes.Rest.ApiClient;
import com.tubes.tubes.Rest.Interface.TopikInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivityTopik extends AppCompatActivity {
    EditText  edtId ,edtJudul, edtKeteranganEdit;
    Button btUpdate, btDelete, btBack;
    TopikInterface mTopikInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_topik);
        edtId = (EditText) findViewById(R.id.edtIdTopikEdit);
        edtJudul = (EditText) findViewById(R.id.edtJudulEdit);
        edtKeteranganEdit = (EditText) findViewById(R.id.edtKeteranganEdit);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id_topik"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtJudul.setText(mIntent.getStringExtra("Judul"));
        edtKeteranganEdit.setText(mIntent.getStringExtra("Keterangan"));
        mTopikInterface = ApiClient.getClient().create(TopikInterface.class);
        btUpdate = (Button) findViewById(R.id.btn_add);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelTopik> updateTopikCall = mTopikInterface.putTopik(
                        edtId.getText().toString(),
                        edtJudul.getText().toString(),
                        edtKeteranganEdit.getText().toString());
                updateTopikCall.enqueue(new Callback<PostPutDelTopik>() {
                    @Override
                    public void onResponse(Call<PostPutDelTopik> call, Response<PostPutDelTopik> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelTopik> call, Throwable t) {
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
                    Call<PostPutDelTopik> deleteTopik = mTopikInterface.deleteTopik(edtId.getText().toString());
                    deleteTopik.enqueue(new Callback<PostPutDelTopik>() {
                        @Override
                        public void onResponse(Call<PostPutDelTopik> call, Response<PostPutDelTopik> response) {
                            MainActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelTopik> call, Throwable t) {
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
