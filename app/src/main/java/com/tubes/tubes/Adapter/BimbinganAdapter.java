package com.tubes.tubes.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tubes.tubes.View.Bimbingan.EditActivityBimbingan;
import com.tubes.tubes.Model.Bimbingan.GetBimbingan;
import com.tubes.tubes.R;

import java.util.List;

public class BimbinganAdapter extends RecyclerView.Adapter<BimbinganAdapter.MyViewHolder> {
    List<GetBimbingan> mBimbinganList;

    public BimbinganAdapter(List<GetBimbingan> BimbinganList) {
        mBimbinganList = BimbinganList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bimbingan_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, @SuppressLint("RecyclerView") final int position){
        holder.mTextViewId.setText("Id_bimbingan= " + mBimbinganList.get(position).getId());
        holder.mTextViewIdMahasiswa.setText("Id_mahasiswa = " + mBimbinganList.get(position).getIdMahasiswa());
        holder.mTextViewIdMentor.setText("Id_mentor = " + mBimbinganList.get(position).getIdMentor());
        holder.mTextViewIdTopik.setText("Id_topik = " + mBimbinganList.get(position).getIdTopik());
        holder.mTextViewWaktu.setText("Waktu = " + mBimbinganList.get(position).getWaktu());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivityBimbingan.class);
                mIntent.putExtra("Id_bimbingan", mBimbinganList.get(position).getId());
                mIntent.putExtra("Id_mahasiswa", mBimbinganList.get(position).getIdMahasiswa());
                mIntent.putExtra("Id_mentor", mBimbinganList.get(position).getIdMentor());
                mIntent.putExtra("Id_topik", mBimbinganList.get(position).getIdTopik());
                mIntent.putExtra("Waktu", mBimbinganList.get(position).getWaktu());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mBimbinganList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewIdMahasiswa, mTextViewIdMentor, mTextViewIdTopik, mTextViewWaktu ;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvIdBimbingan);
            mTextViewIdMahasiswa = (TextView) itemView.findViewById(R.id.tvIdMahasiswa);
            mTextViewIdMentor = (TextView) itemView.findViewById(R.id.tvIdMentor);
            mTextViewIdTopik = (TextView) itemView.findViewById(R.id.tvIdTopik);
            mTextViewWaktu = (TextView) itemView.findViewById(R.id.tvWaktu);
        }
    }
}
