package com.android.vogella.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static com.android.vogella.intent.Main2Activity.RETURNED_DATA;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_CODE = 8988;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        Switch switchButton = findViewById(R.id.switch_button);
        final Button button = findViewById(R.id.button);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    button.setVisibility(View.VISIBLE);
                else
                    button.setVisibility(View.INVISIBLE);
            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    showToast("ON");
                }else{
                    showToast("OFF");
                }
            }
        });

    }

    public void buttonShowToast(View view){
        showToast("Hello! I'm an example of a beautiful custom toast");
    }

    public void showToast(String message){

        LayoutInflater inflater = getLayoutInflater();
        View v;
        v = inflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.customToast));
        TextView tV = v.findViewById(R.id.textView);
        tV.setText(message);
        Toast mCustomToast = new Toast(getApplicationContext());
        mCustomToast.setView(v);
        mCustomToast.setDuration(Toast.LENGTH_SHORT);
        mCustomToast.show();
    }

    public void startGoogle(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://instagram.com/657885_"));
        startActivity(intent);
    }

    public void shareApp(View view){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Download this app");
        intent.setType("text/plain");
        Intent chooser = Intent.createChooser(intent,"Share app using");
        if(chooser.resolveActivity(getPackageManager())!=null){

            startActivity(chooser);
        }
    }

    public void resultExample(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("extra", "Hello there!");
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(data.hasExtra(RETURNED_DATA)){
            if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
                Toast.makeText(this, data.getStringExtra(RETURNED_DATA), Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "No data received! ", Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
