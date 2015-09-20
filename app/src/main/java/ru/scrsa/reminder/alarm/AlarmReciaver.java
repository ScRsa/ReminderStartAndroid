package ru.scrsa.reminder.alarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import ru.scrsa.reminder.MainActivity;
import ru.scrsa.reminder.MyApplication;
import ru.scrsa.reminder.R;

public class AlarmReciaver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent resultIntent;

        String title = intent.getStringExtra("title");
        long timeStamp = intent.getLongExtra("time_stamp", 0);
        int color = intent.getIntExtra("color", 0);

        if (MyApplication.isActivityVisible()) {
            resultIntent = intent;
        } else {
            resultIntent = new Intent(context, MainActivity.class);
        }

        resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, (int) timeStamp, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("Reminder")
                .setContentText(title)
                .setColor(context.getResources().getColor(color))
                .setSmallIcon(R.drawable.ic_checkbox_marked_circle_outline)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(pendingIntent);

        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify((int) timeStamp, notification);

    }
}
