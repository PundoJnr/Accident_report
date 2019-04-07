package com.dhure.accidentreport;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        setTitle("Accident information");
        setContentView(R.layout.activity_report);
    }

    public  void next(View view){
        Intent intent = new Intent(this,report2.class);
        startActivity(intent);
    }
}
