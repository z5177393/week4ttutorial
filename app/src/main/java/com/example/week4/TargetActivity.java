package com.example.week4;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        TextView tv5 = findViewById(R.id.tv_1);
        TextView tv6 = findViewById(R.id.tv_2);
        TextView tv7 = findViewById(R.id.tv_3);
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID",0);
        Article article = FakeDatabase.getArticleById(id);

        tv5.setText(article.getHeadline());
        tv6.setText(article.getContent());
        tv7.setText(article.getAuthor());

    }

}
