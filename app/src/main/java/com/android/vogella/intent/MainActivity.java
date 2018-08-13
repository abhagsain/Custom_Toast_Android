package com.android.vogella.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view){
        View v;
        LayoutInflater inflater = getLayoutInflater();
        v = inflater.inflate(R.layout.custom_toast,null);
        Toast mCustomToast = new Toast(this);
        mCustomToast.setView(v);
        mCustomToast.setDuration(Toast.LENGTH_LONG);
        mCustomToast.show();
    }
}
