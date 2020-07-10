package com.example.latihancodelabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ImplicitActivity extends AppCompatActivity {

    private EditText webEdittext, locEdittext, shareEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        webEdittext = findViewById(R.id.website_edittext);
        locEdittext = findViewById(R.id.location_edittext);
        shareEdittext = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        // mengambil value string
        String url = webEdittext.getText().toString();

        // encode string ke dalam Uri objek
        Uri webpage = Uri.parse(url);

        // Action (param 1) pada Intent yang digunakan adalah action ACTION_VIEW karena akan menampilkan webpage dari uri yang dikirim
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent");
        }
    }

    public void openLocation(View view) {
        String loc = locEdittext.getText().toString();

        // encode string ke dalam Uri objek dengan query geo
        Uri addressUri = Uri.parse("geo:0, 0?q=" + loc);

        Intent locIntent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (locIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(locIntent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent");
        }
    }

    public void openShare(View view) {
        String shareText = shareEdittext.getText().toString();

        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                // from activity yang melaunch intent share
                .from(this)
                // setType digunakan untuk mensetting mimetype pada item yang dishare
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                // setText digunakan untuk mensetting text yang akan dibagikan
                .setText(shareText)
                // startChooser digunakan untuk menampilkan sistem pada aplikasi dan mengirim intent
                .startChooser();
    }
}