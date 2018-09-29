package com.example.jatin.assignment_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Grocery> mGroceries = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGroceries.add(new Grocery("Apple",R.drawable.apple, "$2.00", "0.5lb","3"));
        mGroceries.add(new Grocery("Mango",R.drawable.mango, "$1.00", "0.1lb","3"));
        mGroceries.add(new Grocery("Pineapple",R.drawable.pineapple, "$1.50", "0.3lb","3"));



        mRecyclerView = findViewById(R.id.recycle);

        mAdapter = new MyAdapter(this,mGroceries);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
