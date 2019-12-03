package com.dhure.accidentreport;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.dhure.accidentreport.model.reports;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import static com.dhure.accidentreport.report.MY_PREFS_NAME;

@SuppressWarnings("deprecation")
public class report2 extends AppCompatActivity {

    static final int DATE_DIALOG_ID = 0;
    private int mYear;
    private int mMonth;
    private int mDay;
    private EditText datePicked, timePicked, accidentLocation;
    TimePickerDialog timePickerDialog;
    Button finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report2);

        getSupportActionBar().setTitle("report Accident");

        initViews();

        //show date dialog on click
        datePicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        //get current date
        final Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        updateDisplay();

        getTime();

        storage();
    }

    private void storage() {
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("reports");

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(MY_PREFS_NAME,MODE_PRIVATE);
                String hurt = preferences.getString("hurt", null);
                String vehicle = preferences.getString("vehicle", null);
                String own = preferences.getString("own", null);
                String date = datePicked.getText().toString();
                String time = timePicked.getText().toString();
                String location = accidentLocation.getText().toString();
                String key = reference.push().getKey();
                reports save = new reports(hurt,vehicle,own,date,time,location);
                reference.child(key).setValue(save);

                Toast.makeText(report2.this, "Report successfully submitted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(report2.this, menu.class));
                finish();



            }
        });


    }

    private void getTime() {
        timePicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);



                timePickerDialog = new TimePickerDialog(report2.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timePicked.setText(hourOfDay + ":" + minute);
                    }
                },hour,minute,true);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });
    }

    private void updateDisplay() {
        this.datePicked.setText(
                new StringBuilder()
                        .append(mMonth + 1).append("/")
                        .append(mDay).append("/")
                        .append(mYear).append(" ")

        );
    }
    //callBack for dialog
    private DatePickerDialog.OnDateSetListener mDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear = year;
            mMonth = month;
            mDay = dayOfMonth;

            updateDisplay();
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    private void initViews() {
        datePicked = findViewById(R.id.date);
        timePicked = findViewById(R.id.time);
        finish = findViewById(R.id.finish);
        accidentLocation = findViewById(R.id.location);

    }


}
