package com.example.sprint1implementation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.button);

        start.setOnClickListener(e -> {
            Intent i = new Intent(this, SetupPlayerActivity.class);
            startActivity(i);
        });

        //see deleted code file lines 5-13 for deleted method

    }

    public void moveToConfig(View view) {
        Intent i = new Intent(this, SetupPlayerActivity.class);
        startActivity(i);
    }

    //see deleted code file lines 15-85 for previous deletions

}