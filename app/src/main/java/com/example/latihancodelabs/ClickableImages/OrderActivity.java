package com.example.latihancodelabs.ClickableImages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.latihancodelabs.R;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = intent.getStringExtra(ClickableImagesActivity.EXTRA_MESSAGE);
        TextView orderText = findViewById(R.id.order_textview);
        orderText.setText(message);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    displayToast(getString(R.string.pick_up));
            default:
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}