package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_number);

        Intent previousIntent = getIntent();
        Bundle extras = previousIntent.getExtras();
        String call = extras.getString("call");
        String name = extras.getString("name");
        String number = extras.getString("number");

        EditText nameView = findViewById(R.id.editTextTextPersonName);
        nameView.setText(name);

        EditText numberView = findViewById(R.id.editTextTextPersonName2);
        numberView.setText(number);

        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            EditText nameView = findViewById(R.id.editTextTextPersonName);
            String name2send = nameView.getEditableText().toString();

            EditText numberView = findViewById(R.id.editTextTextPersonName2);
            String number2send = numberView.getEditableText().toString();

            if ((name2send.length()>0) && (number2send.length()>0)){
                    Intent intent = new Intent();
                    String[] sts = new String[] {name2send,number2send,call};
                    intent.putExtra("BackData",sts);
                    setResult(123, intent);
                    finish();
            } else{
                Toast.makeText(getApplicationContext(),
                        "Cannot save this number",
                        Toast.LENGTH_LONG)
                        .show();
            }
        }});
    }

}