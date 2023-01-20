package com.tubes.tubes.View.Mahasiswa;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tubes.tubes.Adapter.MahasiswaAdapter;
import com.tubes.tubes.Model.Mahasiswa.GetMahasiswa;
import com.tubes.tubes.R;
import com.tubes.tubes.Rest.ApiClient;
import com.tubes.tubes.Rest.Interface.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaActivity extends AppCompatActivity {
    Button btnIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MahasiswaActivity ma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);

        btnIns = (Button) findViewById(R.id.btnIns);
        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MahasiswaActivity.this, InsertActivityMahasiswa.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewMhs);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<List<GetMahasiswa>> kontakCall = mApiInterface.getMahasiswa();
        kontakCall.enqueue(new Callback<List<GetMahasiswa>>() {
            @Override
            public void onResponse(Call<List<GetMahasiswa>> call, Response<List<GetMahasiswa>>
                    response) {
                List<GetMahasiswa> MahasiswaList = response.body();
                Log.d("Retrofit Get", "Jumlah data Mahasiswa: " +
                        String.valueOf(MahasiswaList.size()));
                mAdapter = new MahasiswaAdapter(MahasiswaList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<GetMahasiswa>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
