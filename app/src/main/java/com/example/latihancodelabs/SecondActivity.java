package com.example.latihancodelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.latihancodelabs.extra.REPLY";
    public static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private EditText mMessageReply;
    private Button bReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(IntentActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_message);
        if (textView != null) {
            textView.setText(message);
        }

//        handle reply button
        mMessageReply = findViewById(R.id.message_reply);
        bReply = findViewById(R.id.button_reply);

        bReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message_reply = mMessageReply.getText().toString();
                Intent replyIntent = new Intent(SecondActivity.this, MainActivity.class);
                replyIntent.putExtra(EXTRA_REPLY, message_reply);
                setResult(RESULT_OK, replyIntent);
                mMessageReply.setText("");
                finish();
            }
        });
    }
}