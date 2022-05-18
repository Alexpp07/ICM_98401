package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Call extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        Intent previousIntent = getIntent();
        Bundle extras = previousIntent.getExtras();
        String text = extras.getString("textViewString");
        TextView tV = findViewById(R.id.textView3);
        tV.setText(text);
    }

    public void back(View view){
        finish();
    }
}