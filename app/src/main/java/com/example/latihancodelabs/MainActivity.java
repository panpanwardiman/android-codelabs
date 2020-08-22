package com.example.latihancodelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.latihancodelabs.AlarmManager.AlarmManagerActivity;
import com.example.latihancodelabs.AsyncTask.AsyncTaskActivity;
import com.example.latihancodelabs.BroadCast.BroadCastActivity;
import com.example.latihancodelabs.CardAndColors.CardColorActivity;
import com.example.latihancodelabs.ClickableImages.ClickableImagesActivity;
import com.example.latihancodelabs.Debuger.DebugerActivity;
import com.example.latihancodelabs.Notification.NotificationActivity;
import com.example.latihancodelabs.Picker.PickerActivity;
import com.example.latihancodelabs.RecycleView.RecycleViewActivity;
import com.example.latihancodelabs.TabExperiment.TabExperimentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void activitiesAndIntents(View view) {
        Intent goToActivitiesAndIntent = new Intent(this, IntentActivity.class);
        startActivity(goToActivitiesAndIntent);
    }

    public void implicitIntent(View view) {
        Intent goToImplicitIntent = new Intent(this, ImplicitActivity.class);
        startActivity(goToImplicitIntent);
    }

    public void debugerAction(View view) {
        Intent goToDebuger = new Intent(this, DebugerActivity.class);
        startActivity(goToDebuger);
    }

    public void clickableImages(View view) {
        Intent goToClickableImage = new Intent(this, ClickableImagesActivity.class);
        startActivity(goToClickableImage);
    }

    public void tabExperience(View view) {
        Intent goTabExperience = new Intent(this, TabExperimentActivity.class);
        startActivity(goTabExperience);
    }

    public void scrollViewAction(View view) {
        Intent goToScrollView = new Intent(this, ScrollViewActivity.class);
        startActivity(goToScrollView);
    }

    public void picker(View view) {
        Intent goToPicker = new Intent(this, PickerActivity.class);
        startActivity(goToPicker);
    }

    public void recyclerViewAction(View view) {
        Intent goToRecyclerView = new Intent(this, RecycleViewActivity.class);
        startActivity(goToRecyclerView);
    }

    public void scoreKeeper(View view) {
        Intent goToScoreKeeper = new Intent(this, ScoreKeeperActivity.class);
        startActivity(goToScoreKeeper);
    }

    public void cardAndColor(View view) {
        Intent goToCardColor = new Intent(this, CardColorActivity.class);
        startActivity(goToCardColor);
    }

    public void asyncTaskAction(View view) {
        Intent goToCardColor = new Intent(this, AsyncTaskActivity.class);
        startActivity(goToCardColor);
    }

    public void broadCast(View view) {
        Intent goToCardColor = new Intent(this, BroadCastActivity.class);
        startActivity(goToCardColor);
    }

    public void notificationAction(View view) {
        Intent goToCardColor = new Intent(this, NotificationActivity.class);
        startActivity(goToCardColor);
    }

    public void alarmManager(View view) {
        Intent goToCardColor = new Intent(this, AlarmManagerActivity.class);
        startActivity(goToCardColor);
    }
}