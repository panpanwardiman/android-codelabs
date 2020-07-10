package com.example.latihancodelabs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.latihancodelabs.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    Button send;
    private EditText mMessageText;
    private TextView mReplyHeadTextView, mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        mMessageText = findViewById(R.id.message_text);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        send = findViewById(R.id.button_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(LOG_TAG, "Button clicked!");
                String message = mMessageText.getText().toString();
                Intent intent = new Intent(IntentActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivityForResult(intent, TEXT_REQUEST);

                mMessageText.setText("");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}