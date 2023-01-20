package com.tubes.tubes.View.Topik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tubes.tubes.MainActivity;
import com.tubes.tubes.Model.Mentor.PostPutDelMentor;
import com.tubes.tubes.Model.Topik.PostPutDelTopik;
import com.tubes.tubes.R;
import com.tubes.tubes.Rest.ApiClient;
import com.tubes.tubes.Rest.Interface.TopikInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivityTopik extends AppCompatActivity {
    EditText edtJudul, edtKeterangan;
    Button btInsert, btBack;
    TopikInterface mTopikInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_topik);
        edtJudul = (EditText) findViewById(R.id.edtJudul);
        edtKeterangan = (EditText) findViewById(R.id.edtKeterangan);
        mTopikInterface = ApiClient.getClient().create(TopikInterface.class);
        btInsert = (Button) findViewById(R.id.btn_add);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelTopik> postTopikCall = mTopikInterface.postTopik(edtJudul.getText().toString(), edtKeterangan.getText().toString());
                postTopikCall.enqueue(new Callback<PostPutDelTopik>() {
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
