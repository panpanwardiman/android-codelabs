package com.example.latihancodelabs.AlarmManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.latihancodelabs.R;

public class AlarmManagerActivity extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";

    private NotificationManager notificationManager;
    ToggleButton alarmToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        alarmToggle = findViewById(R.id.alarmToggle);

        // Set up the Notification Broadcast Intent.
        Intent notifyIntent = new Intent(this, AlarmReceiver.class);

        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID,
                notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);
        alarmToggle.setChecked(alarmUp);

        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        final AlarmManager alarmManager = (AlarmManager) getSystemService
                (ALARM_SERVICE);

        alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                String toastMessage;
                if (isChecked) {
                    long repeatInterval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;

                    long triggerTime = SystemClock.elapsedRealtime()
                            + repeatInterval;

                    // If the Toggle is turned on, set the repeating alarm with
                    // a 15 minute interval.
                    if (alarmManager != null) {
                        alarmManager.setInexactRepeating
                                (AlarmManager.ELAPSED_REALTIME_WAKEUP,
                                        triggerTime, repeatInterval,
                                        notifyPendingIntent);
                    }

                    // Set the toast message for the "on" case.
                    toastMessage = getString(R.string.alarm_on_toast);
                } else {
                    // Cancel notification if the alarm is turned off.
                    notificationManager.cancelAll();

                    if (alarmManager != null) {
                        alarmManager.cancel(notifyPendingIntent);
                    }
                    // Set the toast message for the "off" case.
                    toastMessage = getString(R.string.alarm_off_toast);
                }

                Toast.makeText(AlarmManagerActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });

        createNotificationChannel();
    }

    public void createNotificationChannel() {

        // Create a notification manager object.
        notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Stand up notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Notifies every 15 minutes to stand up and walk");
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void deliverNotification(Context context) {
        Intent contentIntent = new Intent(context, AlarmManagerActivity.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_stand_up)
                .setContentTitle("Stand Up Alert")
                .setContentText("You should stand up and walk around now!")
                .setContentIntent(contentPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}