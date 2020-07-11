package com.example.latihancodelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.latihancodelabs.ClickableImages.ClickableImagesActivity;
import com.example.latihancodelabs.Debuger.DebugerActivity;

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
}