package com.android.vogella.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public static final String RETURNED_DATA = "returned_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String s = intent.getStringExtra("extra");
        TextView tv = findViewById(R.id.text);
        if(!s.isEmpty())
        tv.setText(s);
    }


    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(RETURNED_DATA,"Data received successfully");
        setResult(RESULT_OK,intent);
        super.finish();
    }
}
