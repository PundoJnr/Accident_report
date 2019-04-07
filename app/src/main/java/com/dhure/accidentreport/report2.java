package com.dhure.accidentreport;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class report2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);
        Button bt = (Button) findViewById(R.id.finish);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //write and send report
            }
        });
    }




}
