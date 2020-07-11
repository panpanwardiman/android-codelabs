package com.example.latihancodelabs.ClickableImages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.latihancodelabs.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ClickableImagesActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.latihancodelabs.ClickableImages.extra.MESSAGE";

    private String mOrderMessage;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickable_images);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToOrder = new Intent(ClickableImagesActivity.this, OrderActivity.class);
                goToOrder.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(goToOrder);
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }

    public void showIceCreamOrder(View view) {
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
    }

    public void showFroyoOrder(View view) {
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }
}