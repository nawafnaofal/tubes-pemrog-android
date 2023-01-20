package com.tubes.tubes.View.Topik;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tubes.tubes.Adapter.TopikAdapter;
import com.tubes.tubes.Model.Topik.GetTopik;
import com.tubes.tubes.R;
import com.tubes.tubes.Rest.ApiClient;
import com.tubes.tubes.Rest.Interface.TopikInterface;
import com.tubes.tubes.View.Topik.InsertActivityTopik;
import com.tubes.tubes.View.Topik.TopikActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopikActivity extends AppCompatActivity {

    Button btnIns;
    TopikInterface mTopikInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static TopikActivity ma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topik);

        btnIns = (Button) findViewById(R.id.btnIns);
        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TopikActivity.this, InsertActivityTopik.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewTopik);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mTopikInterface = ApiClient.getClient().create(TopikInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<List<GetTopik>> kontakCall = mTopikInterface.getTopik();
        kontakCall.enqueue(new Callback<List<GetTopik>>() {
            @Override
            public void onResponse(Call<List<GetTopik>> call, Response<List<GetTopik>>
                    response) {
                List<GetTopik> TopikList = response.body();
                Log.d("Retrofit Get", "Jumlah data Topik: " +
                        String.valueOf(TopikList.size()));
                mAdapter = new TopikAdapter(TopikList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<GetTopik>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
