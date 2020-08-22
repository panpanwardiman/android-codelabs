package com.example.latihancodelabs.CardAndColors;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.latihancodelabs.R;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportViewHolder> {
    private ArrayList<Sport> mSportData;
    private Context mContext;

    SportAdapter(Context context, ArrayList<Sport> sportData) {
        this.mContext = context;
        this.mSportData = sportData;
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SportViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position) {
        Sport currentSport = mSportData.get(position);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportData.size();
    }

    public class SportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mImageSport;

        SportViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mImageSport = itemView.findViewById(R.id.sportImage);

            itemView.setOnClickListener(this);
        }

        void bindTo(Sport currentSport) {
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            Glide.with(mContext).load(currentSport.getImageResource()).into(mImageSport);
        }

        @Override
        public void onClick(View view) {
            Sport currentSport = mSportData.get(getAdapterPosition());
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("title", currentSport.getTitle());
            intent.putExtra("image_resource", currentSport.getImageResource());
            mContext.startActivity(intent);
        }
    }
}
