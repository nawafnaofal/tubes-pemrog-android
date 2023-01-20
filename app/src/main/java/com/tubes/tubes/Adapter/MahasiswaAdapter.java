package com.tubes.tubes.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tubes.tubes.View.Mahasiswa.EditActivityMahasiswa;
import com.tubes.tubes.Model.Mahasiswa.GetMahasiswa;
import com.tubes.tubes.R;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MyViewHolder> {
    List<GetMahasiswa> mMahasiswaList;

    public MahasiswaAdapter(List<GetMahasiswa> MahasiswaList) {
        mMahasiswaList = MahasiswaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, @SuppressLint("RecyclerView") final int position){
        holder.mTextViewId.setText("Id_mahasiswa= " + mMahasiswaList.get(position).getId());
        holder.mTextViewNama.setText("Nama = " + mMahasiswaList.get(position).getNama());
        holder.mTextViewNpm.setText("Npm = " + mMahasiswaList.get(position).getNpm());
        holder.mTextViewJurusan.setText("Jurusan = " + mMahasiswaList.get(position).getJurusan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivityMahasiswa.class);
                mIntent.putExtra("Id_mahasiswa", mMahasiswaList.get(position).getId());
                mIntent.putExtra("Nama", mMahasiswaList.get(position).getNama());
                mIntent.putExtra("Npm", mMahasiswaList.get(position).getNpm());
                mIntent.putExtra("Jurusan", mMahasiswaList.get(position).getJurusan());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mMahasiswaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNpm, mTextViewJurusan ;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewNpm = (TextView) itemView.findViewById(R.id.tvNpm);
            mTextViewJurusan = (TextView) itemView.findViewById(R.id.tvJurusan);
        }
    }
}
