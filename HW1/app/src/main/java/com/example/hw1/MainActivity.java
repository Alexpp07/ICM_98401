package com.example.hw1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String textViewString = "";
    ArrayList<ArrayList> numbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> call1 = new ArrayList<>();
        call1.add("-");
        call1.add("None1");
        ArrayList<String> call2 = new ArrayList<>();
        call2.add("-");
        call2.add("None2");
        ArrayList<String> call3 = new ArrayList<>();
        call3.add("-");
        call3.add("None3");
        if (numbers.isEmpty()){
            numbers.add(call1);
            numbers.add(call2);
            numbers.add(call3);
        }

        Button buttonCall1 = findViewById(R.id.buttonCall1);
        buttonCall1.setText(numbers.get(0).get(0).toString());

        buttonCall1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdateNumber.class);
                intent.putExtra("call","1");
                intent.putExtra("name",numbers.get(0).get(0).toString());
                intent.putExtra("number",numbers.get(0).get(1).toString());
                startActivityForResult(intent, 123);
                return false;
            }
        });

        Button buttonCall2 = findViewById(R.id.buttonCall2);
        buttonCall2.setText(numbers.get(1).get(0).toString());

        buttonCall2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdateNumber.class);
                intent.putExtra("call","2");
                intent.putExtra("name",numbers.get(1).get(0).toString());
                intent.putExtra("number",numbers.get(1).get(1).toString());
                startActivityForResult(intent, 123);
                return false;
            }
        });

        Button buttonCall3 = findViewById(R.id.buttonCall3);
        buttonCall3.setText(numbers.get(2).get(0).toString());

        buttonCall3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdateNumber.class);
                intent.putExtra("call","3");
                intent.putExtra("name",numbers.get(2).get(0).toString());
                intent.putExtra("number",numbers.get(2).get(1).toString());
                startActivityForResult(intent, 123);
                return false;
            }
        });
    }

    public void one(View view){
        textViewString = textViewString + "1";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void two(View view){
        textViewString = textViewString + "2";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void three(View view){
        textViewString = textViewString + "3";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void four(View view){
        textViewString = textViewString + "4";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void five(View view){
        textViewString = textViewString + "5";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void six(View view){
        textViewString = textViewString + "6";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void seven(View view){
        textViewString = textViewString + "7";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void eight(View view){
        textViewString = textViewString + "8";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void nine(View view){
        textViewString = textViewString + "9";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void zero(View view){
        textViewString = textViewString + "0";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void call(View view) {
        if (textViewString.length()==0){
            Toast.makeText(getApplicationContext(),
                    "Cannot call this number",
                    Toast.LENGTH_LONG)
                    .show();
        } else {
            //Intent intent = new Intent(this, Call.class);
            //intent.putExtra("textViewString", textViewString);
            //startActivity(intent);
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+textViewString));//change the number
            startActivity(callIntent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (123 == requestCode){
            try {
                String[] sts = data.getStringArrayExtra("BackData");
                String name = sts[0];
                String number = sts[1];
                String call = sts[2];
                switch (call){
                    case "1":
                        Button buttonCall1 = findViewById(R.id.buttonCall1);
                        ArrayList<String> call1 = new ArrayList<>();
                        call1.add(name);
                        call1.add(number);
                        numbers.set(0,call1);
                        buttonCall1.setText(name);
                        Toast.makeText(getApplicationContext(),
                                "Contact Created",
                                Toast.LENGTH_LONG)
                                .show();
                        break;
                    case "2":
                        Button buttonCall2 = findViewById(R.id.buttonCall2);
                        ArrayList<String> call2 = new ArrayList<>();
                        call2.add(name);
                        call2.add(number);
                        numbers.set(1,call2);
                        buttonCall2.setText(name);
                        Toast.makeText(getApplicationContext(),
                                "Contact Created",
                                Toast.LENGTH_LONG)
                                .show();
                        break;
                    case "3":
                        Button buttonCall3 = findViewById(R.id.buttonCall3);
                        ArrayList<String> call3 = new ArrayList<>();
                        call3.add(name);
                        call3.add(number);
                        numbers.set(2,call3);
                        buttonCall3.setText(name);
                        Toast.makeText(getApplicationContext(),
                                "Contact Created",
                                Toast.LENGTH_LONG)
                                .show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),
                                "Error creating contact",
                                Toast.LENGTH_LONG)
                                .show();
                        break;
                }

            }catch(Exception e){
                //e.printStackTrace();
            }
        }
    }

    public void call1(View view){
        textViewString = numbers.get(0).get(1).toString();
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void call2(View view){
        textViewString = numbers.get(1).get(1).toString();
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void call3(View view){
        textViewString = numbers.get(2).get(1).toString();
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void delete(View view){
        if (textViewString.length()>0){
            textViewString = textViewString.substring(0,textViewString.length()-1);
            TextView textView = (TextView) findViewById(R.id.textView2);
            textView.setText(textViewString);
        }
    }

    public void add(View view){
        textViewString = textViewString + "+";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }

    public void cardinal(View view){
        textViewString = textViewString + "#";
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(textViewString);
    }
}