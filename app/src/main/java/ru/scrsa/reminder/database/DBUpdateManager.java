package ru.scrsa.reminder.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import ru.scrsa.reminder.model.ModelTask;

public class DBUpdateManager {

    private SQLiteDatabase database;

    public DBUpdateManager(SQLiteDatabase database) {
        this.database = database;
    }

    private void update(String column, long key, String value) {
        ContentValues cv = new ContentValues();
        cv.put(column, value);
        database.update(DBHelper.TASK_TABLE, cv, DBHelper.TASK_TIME_STAMP_COLUMN + " = " + key, null);
    }

    private void update(String column, long key, long value) {
        ContentValues cv = new ContentValues();
        cv.put(column, value);
        database.update(DBHelper.TASK_TABLE, cv, DBHelper.TASK_TIME_STAMP_COLUMN + " = " + key, null);
    }

    public void title(long timeStamp, String value) {
        update(DBHelper.TASK_TITLE_COLUMN, timeStamp, value);
    }

    public void date(long timeStamp, long value) {
        update(DBHelper.TASK_DATE_COLUMN, timeStamp, value);
    }

    public void priority(long timeStamp, int value) {
        update(DBHelper.TASK_PRIORITY_COLUMN, timeStamp, value);
    }

    public void status(long timeStamp, int value) {
        update(DBHelper.TASK_STATUS_COLUMN, timeStamp, value);
    }

    public void task(ModelTask task) {
        title(task.getTimestamp(), task.getTitle());
        date(task.getTimestamp(), task.getDate());
        priority(task.getTimestamp(), task.getPriority());
        status(task.getTimestamp(), task.getStatus());
    }

}
