package com.example.latihancodelabs.CardAndColors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.example.latihancodelabs.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CardColorActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSport;
    private SportAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_color);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        mSport = new ArrayList<>();

        mAdapter = new SportAdapter(this, mSport);
        mRecyclerView.setAdapter(mAdapter);

        initalizeData();

        int swipeDirs;
        if (gridColumnCount > 1) {
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                                ItemTouchHelper.DOWN | ItemTouchHelper.UP , swipeDirs) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                Collections.swap(mSport, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                mSport.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(mRecyclerView);
    }

    private void initalizeData() {
        String[] sportList = getResources().getStringArray(R.array.sports_titles);
        String[] sportInfo = getResources().getStringArray(R.array.sports_info);
        TypedArray sportImageResource = getResources().obtainTypedArray(R.array.sports_images);

        mSport.clear();

        for (int i=0; i<sportList.length; i++) {
            mSport.add(new Sport(sportList[i], sportInfo[i], sportImageResource.getResourceId(i,0)));
        }
        sportImageResource.recycle();
        mAdapter.notifyDataSetChanged();
    }

    public void resetSports(View view) {
        initalizeData();
    }
}