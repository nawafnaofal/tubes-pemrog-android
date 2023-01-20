package com.tubes.tubes.View.Mentor;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tubes.tubes.Adapter.MentorAdapter;
import com.tubes.tubes.Model.Mentor.GetMentor;
import com.tubes.tubes.R;
import com.tubes.tubes.Rest.ApiClient;
import com.tubes.tubes.Rest.Interface.MentorInterface;
import com.tubes.tubes.View.Mentor.InsertActivityMentor;
import com.tubes.tubes.View.Mentor.MentorActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MentorActivity extends AppCompatActivity  {
    Button btnIns;
    MentorInterface mMentorInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MentorActivity ma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);

        btnIns = (Button) findViewById(R.id.btnIns);
        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MentorActivity.this, InsertActivityMentor.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewMentor);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mMentorInterface = ApiClient.getClient().create(MentorInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<List<GetMentor>> kontakCall = mMentorInterface.getMentor();
        kontakCall.enqueue(new Callback<List<GetMentor>>() {
            @Override
            public void onResponse(Call<List<GetMentor>> call, Response<List<GetMentor>>
                    response) {
                List<GetMentor> MentorList = response.body();
                Log.d("Retrofit Get", "Jumlah data Mentor: " +
                        String.valueOf(MentorList.size()));
                mAdapter = new MentorAdapter(MentorList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<GetMentor>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
