package com.tubes.tubes.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tubes.tubes.View.Mentor.EditActivityMentor;
import com.tubes.tubes.Model.Mentor.GetMentor;
import com.tubes.tubes.R;

import java.util.List;

public class MentorAdapter extends RecyclerView.Adapter<MentorAdapter.MyViewHolder> {
    List<GetMentor> mMentorList;

    public MentorAdapter(List<GetMentor> MentorList) {
        mMentorList = MentorList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mentor_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, @SuppressLint("RecyclerView") final int position){
        holder.mTextViewId.setText("Id_mentor = " + mMentorList.get(position).getId());
        holder.mTextViewNama.setText("Nama = " + mMentorList.get(position).getNama());
        holder.mTextViewNip.setText("Nip = " + mMentorList.get(position).getNip());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivityMentor.class);
                mIntent.putExtra("Id_mentor", mMentorList.get(position).getId());
                mIntent.putExtra("Nama", mMentorList.get(position).getNama());
                mIntent.putExtra("Nip", mMentorList.get(position).getNip());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mMentorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNip;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvIdMentorList);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNamaMentor);
            mTextViewNip = (TextView) itemView.findViewById(R.id.tvNip);
        }
    }
}
