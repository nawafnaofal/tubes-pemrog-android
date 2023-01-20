package com.tubes.tubes.View.Bimbingan;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tubes.tubes.Adapter.BimbinganAdapter;
import com.tubes.tubes.Model.Bimbingan.GetBimbingan;
import com.tubes.tubes.R;
import com.tubes.tubes.Rest.ApiClient;
import com.tubes.tubes.Rest.Interface.BimbinganInterface;
import com.tubes.tubes.View.Bimbingan.InsertActivityBimbingan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BimbinganActivity extends AppCompatActivity {

    Button btnIns;
    BimbinganInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static BimbinganActivity ma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bimbingan);

        btnIns = (Button) findViewById(R.id.btnIns10);
        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BimbinganActivity.this, InsertActivityBimbingan.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewBimb);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(BimbinganInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<List<GetBimbingan>> kontakCall = mApiInterface.getBimbingan();
        kontakCall.enqueue(new Callback<List<GetBimbingan>>() {
            @Override
            public void onResponse(Call<List<GetBimbingan>> call, Response<List<GetBimbingan>>
                    response) {
                List<GetBimbingan> BimbinganList = response.body();
                Log.d("Retrofit Get", "Jumlah data Bimbingan: " +
                        String.valueOf(BimbinganList.size()));
                mAdapter = new BimbinganAdapter(BimbinganList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<GetBimbingan>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

}
