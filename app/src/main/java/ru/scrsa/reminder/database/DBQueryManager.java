package ru.scrsa.reminder.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.AvoidXfermode;

import java.util.ArrayList;
import java.util.List;

import ru.scrsa.reminder.model.ModelTask;

public class DBQueryManager {

    private SQLiteDatabase database;

    public DBQueryManager(SQLiteDatabase database) {
        this.database = database;
    }

    public  ModelTask getTask(long timeStamp) {
        ModelTask modelTask = null;
        Cursor c = database.query(DBHelper.TASK_TABLE, null, DBHelper.SELECTION_TIME_STAMP,
                new String[]{Long.toString(timeStamp)}, null, null, null);

        if (c.moveToFirst()) {
            String title = c.getString(c.getColumnIndex(DBHelper.TASK_TITLE_COLUMN));
            long date = c.getLong(c.getColumnIndex(DBHelper.TASK_DATE_COLUMN));
            int priority = c.getInt(c.getColumnIndex(DBHelper.TASK_PRIORITY_COLUMN));
            int status = c.getInt(c.getColumnIndex(DBHelper.TASK_STATUS_COLUMN));

            modelTask = new ModelTask(title, date, priority, status, timeStamp);
        }
        c.close();

        return modelTask;
    }

    public List<ModelTask> getTasks(String selection, String[] selectionArgs, String orderBy) {
        List<ModelTask> tasks = new ArrayList<>();

        Cursor c = database.query(DBHelper.TASK_TABLE, null, selection, selectionArgs, null, null, orderBy);

        if (c.moveToFirst()) {
            do {
                String title = c.getString(c.getColumnIndex(DBHelper.TASK_TITLE_COLUMN));
                long date = c.getLong(c.getColumnIndex(DBHelper.TASK_DATE_COLUMN));
                int priority = c.getInt(c.getColumnIndex(DBHelper.TASK_PRIORITY_COLUMN));
                int status = c.getInt(c.getColumnIndex(DBHelper.TASK_STATUS_COLUMN));
                long timestamp = c.getLong(c.getColumnIndex(DBHelper.TASK_TIME_STAMP_COLUMN));

                ModelTask task = new ModelTask(title, date, priority, status, timestamp);
                tasks.add(task);
            } while (c.moveToNext());
        }
        c.close();

        return tasks;
    }
}
