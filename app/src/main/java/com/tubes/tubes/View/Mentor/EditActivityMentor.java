package com.tubes.tubes.View.Mentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class EditActivityMentor extends AppCompatActivity {
    EditText  edtId ,edtNama, edtNip, edtJurusan;
    Button btUpdate, btDelete, btBack;
    MentorInterface mMentorInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mentor);
        edtId = (EditText) findViewById(R.id.edtIdMentorEdit);
        edtNama = (EditText) findViewById(R.id.edtNamaMentorEdit);
        edtNip = (EditText) findViewById(R.id.edtNipEdit);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id_mentor"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edtNip.setText(mIntent.getStringExtra("Nip"));
        mMentorInterface = ApiClient.getClient().create(MentorInterface.class);
        btUpdate = (Button) findViewById(R.id.btn_add);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelMentor> updateMentorCall = mMentorInterface.putMentor(
                        edtId.getText().toString(),
                        edtNama.getText().toString(),
                        edtNip.getText().toString());
                updateMentorCall.enqueue(new Callback<PostPutDelMentor>() {
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
        btDelete = (Button) findViewById(R.id.btn_back);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelMentor> deleteMentor = mMentorInterface.deleteMentor(edtId.getText().toString());
                    deleteMentor.enqueue(new Callback<PostPutDelMentor>() {
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
