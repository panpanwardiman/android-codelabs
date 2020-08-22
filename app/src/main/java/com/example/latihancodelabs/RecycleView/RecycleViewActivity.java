package com.example.latihancodelabs.RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.latihancodelabs.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class RecycleViewActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView recyclerView;
    private WordListAdapter mAdapter;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();
                mWordList.addLast("+ Word " + wordListSize);
                recyclerView.getAdapter().notifyItemInserted(wordListSize);
                recyclerView.smoothScrollToPosition(wordListSize);
            }
        });

        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }

        recyclerView = findViewById(R.id.recycleview);
        mAdapter = new WordListAdapter(this, mWordList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}