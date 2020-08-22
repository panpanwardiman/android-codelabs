package com.example.latihancodelabs.Picker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.latihancodelabs.R;

public class PickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(PickerActivity.this);
        myAlertBuilder.setTitle("Alert");
        myAlertBuilder.setMessage("Click Ok to continue, or Cancel to stop:");
        myAlertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Pressed Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Pressed Ok", Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.show();
    }

    public void showDatePicker(View view) {
        DialogFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show(getSupportFragmentManager(), "datepicker");
    }

    public void showTimePicker(View view) {
        DialogFragment dialogTimeFragment = new TimePickerFragment();
        dialogTimeFragment.show(getSupportFragmentManager(), "timepicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string + "/" + month_string + "/" + year_string);

        Toast.makeText(getApplicationContext(), dateMessage, Toast.LENGTH_SHORT).show();
    }

    public void processTimePickerResult(int hour, int minute) {
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);

        String dateMessage = ("Time:" + hour_string + "/" + minute_string);

        Toast.makeText(getApplicationContext(), dateMessage, Toast.LENGTH_SHORT).show();
    }
}