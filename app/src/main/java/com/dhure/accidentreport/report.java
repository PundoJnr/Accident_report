package com.dhure.accidentreport;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class report extends AppCompatActivity {

    static final String MY_PREFS_NAME = "My Prefs file";
    RadioButton hurty, hurtn, vehy, vehn, owny, ownn;
    RadioGroup one, two, three;
    Button finish;

    private String hurt ="";
    private String vehicle ="";
    private String own ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        setTitle("Accident information");

        initVIews();

        final String[] hurt = {hurty.getText().toString()};

        one.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.hYes:

                        hurt[0] = "hurt";
                        break;
                    case R.id.hNo:
                        hurt[0] = "notHurt";
                }
            }
        });

        final String[] vehicle = {vehy.getText().toString()};

        two.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.vYes:
                        vehicle[0] = "driver";
                        break;
                    case R.id.vNo:
                        vehicle[0] = "passenger";
                }
            }
        });


        final String[] own = {owny.getText().toString()};

        two.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.oYes:
                        own[0] = "owner";
                        break;
                    case R.id.oNo:
                        own[0] = "notOwner";
                }
            }
        });

        sharedPref();
    }

    private void sharedPref() {
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE).edit();
        editor.putString("hurt",hurt);
        editor.putString("vehicle",vehicle);
        editor.putString("owner",own);
        editor.apply();
    }

    private void initVIews() {
        hurty = findViewById(R.id.hYes);
        hurtn = findViewById(R.id.hNo);
        vehy = findViewById(R.id.vYes);
        vehn = findViewById(R.id.vNo);
        owny = findViewById(R.id.oYes);
        ownn = findViewById(R.id.oNo);
        one = findViewById(R.id.radio_group);
        two =findViewById(R.id.radio_group2);
        three = findViewById(R.id.radio_group3);
    }

    public  void next(View view){
        Intent intent = new Intent(this,report2.class);
        startActivity(intent);
    }
}
