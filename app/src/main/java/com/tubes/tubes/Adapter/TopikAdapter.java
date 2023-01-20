package com.tubes.tubes.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.tubes.tubes.View.Topik.EditActivityTopik;
import com.tubes.tubes.Model.Topik.GetTopik;
import com.tubes.tubes.R;

import java.util.List;

public class TopikAdapter extends RecyclerView.Adapter<TopikAdapter.MyViewHolder> {
    List<GetTopik> mTopikList;

    public TopikAdapter(List<GetTopik> TopikList) {
        mTopikList = TopikList;
    }

    @Override
    public TopikAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.topik_list, parent, false);
        TopikAdapter.MyViewHolder mViewHolder = new TopikAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (TopikAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position){
        holder.mTextViewId.setText("Id_topik= " + mTopikList.get(position).getId());
        holder.mTextViewJudul.setText("Judul = " + mTopikList.get(position).getJudul());
        holder.mTextViewKeterangan.setText("Keterangan = " + mTopikList.get(position).getKeterangan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivityTopik.class);
                mIntent.putExtra("Id_topik", mTopikList.get(position).getId());
                mIntent.putExtra("Judul", mTopikList.get(position).getJudul());
                mIntent.putExtra("Keterangan", mTopikList.get(position).getKeterangan());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mTopikList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewJudul, mTextViewKeterangan;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvIdTopikList);
            mTextViewJudul = (TextView) itemView.findViewById(R.id.tvJudulTopik);
            mTextViewKeterangan = (TextView) itemView.findViewById(R.id.tvKeterangan);
        }
    }
}
