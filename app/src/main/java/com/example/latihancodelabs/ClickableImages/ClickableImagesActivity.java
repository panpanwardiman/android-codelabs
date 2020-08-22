package com.example.latihancodelabs.ClickableImages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.latihancodelabs.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.latihancodelabs.R.*;
import static com.example.latihancodelabs.R.menu.menu_main;

public class ClickableImagesActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.latihancodelabs.ClickableImages.extra.MESSAGE";

    private String mOrderMessage;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_clickable_images);

        fab = findViewById(id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToOrder = new Intent(ClickableImagesActivity.this, OrderActivity.class);
                goToOrder.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(goToOrder);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent goToOrder = new Intent(this, OrderActivity.class);
                goToOrder.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(goToOrder);
                return true;
            case R.id.action_status:
                displayToast(getString(string.action_status_message));
                return true;
            case R.id.action_favorite:
                displayToast(getString(string.action_favorites_message));
                return true;
            case R.id.action_contact:
                displayToast(getString(string.action_contact_message));
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        mOrderMessage = getString(string.donut_order_message);
        displayToast(mOrderMessage);
    }

    public void showIceCreamOrder(View view) {
        mOrderMessage = getString(string.ice_cream_order_message);
        displayToast(mOrderMessage);
    }

    public void showFroyoOrder(View view) {
        mOrderMessage = getString(string.froyo_order_message);
        displayToast(mOrderMessage);
    }
}