package ru.scrsa.reminder.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import ru.scrsa.reminder.model.ModelTask;

public class AlarmHelper {

    private static AlarmHelper instance;
    private Context context;
    private AlarmManager alarmManager;

    public static AlarmHelper getInstance() {

        if (instance == null) {
            instance = new AlarmHelper();
        }
        return instance;
    }

    public AlarmHelper init(Context context) {
        this.context = context;
        this.alarmManager = (AlarmManager) context.getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        return null;
    }

    public void setAlarm(ModelTask task) {
        Intent intent = new Intent(context, AlarmReciaver.class);
        intent.putExtra("title", task.getTitle());
        intent.putExtra("time_stamp", task.getTimestamp());
        intent.putExtra("color", task.getPriorityColor());

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(),
                (int) task.getTimestamp(), intent, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP, task.getDate(), pendingIntent);
    }

    public void removeAlarm(long timeStamp) {
        Intent intent = new Intent(context, AlarmReciaver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                (int) timeStamp, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.cancel(pendingIntent);
    }
}
