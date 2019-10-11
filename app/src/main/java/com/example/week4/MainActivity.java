package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnNoteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter articleAdapter = new RecyclerViewAdapter(this);
        articleAdapter.setData(FakeDatabase.getAllArticles());
        recyclerView.setAdapter(articleAdapter);
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(getApplicationContext(), TargetActivity.class);
        intent.putExtra("ID", position+1);
        startActivity(intent);
    }
}
