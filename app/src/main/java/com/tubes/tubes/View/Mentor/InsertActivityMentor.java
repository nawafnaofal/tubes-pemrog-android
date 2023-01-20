package com.tubes.tubes.View.Mentor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tubes.tubes.MainActivity;
import com.tubes.tubes.Model.Mentor.PostPutDelMentor;
import com.tubes.tubes.R;
import com.tubes.tubes.Rest.ApiClient;
import com.tubes.tubes.Rest.Interface.MentorInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivityMentor extends AppCompatActivity {
    EditText edtNama, edtNip;
    Button btInsert, btBack;
    MentorInterface mMentorInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mentor);
        edtNama = (EditText) findViewById(R.id.edtNamaMentor);
        edtNip = (EditText) findViewById(R.id.edtNipAdd);
        mMentorInterface = ApiClient.getClient().create(MentorInterface.class);
        btInsert = (Button) findViewById(R.id.btn_add);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelMentor> postMentorCall = mMentorInterface.postMentor(edtNama.getText().toString(), edtNip.getText().toString());
                postMentorCall.enqueue(new Callback<PostPutDelMentor>() {
                    @Override
                    public void onResponse(Call<PostPutDelMentor> call, Response<PostPutDelMentor> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelMentor> call, Throwable t) {
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
