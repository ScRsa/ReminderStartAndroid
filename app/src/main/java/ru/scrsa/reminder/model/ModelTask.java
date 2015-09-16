package ru.scrsa.reminder.model;

import ru.scrsa.reminder.R;

public class ModelTask implements Item {

    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_NORMAL = 1;
    public static final int PRIORITY_HIGH = 2;

    public static final String[] PRIORITY_LEVELS = {"Low", "Normal", "High"};

    public static int STATUS_OVERDUE = 0;
    public static int STATUS_CURRENT = 1;
    public static int STATUS_DONE = 2;

    private String title;
    private long date;
    private int priority;
    private int status;

    public ModelTask() {
        status = -1;
    }

    public ModelTask(String title, long date, int priority, int status) {
        this.title = title;
        this.date = date;
        this.priority = priority;
        this.status = status;
    }

    public int getPriorityColor() {

        if (getStatus() == STATUS_CURRENT || getStatus() == STATUS_OVERDUE ) {
            switch (getPriority()){
                case PRIORITY_LOW:
                    return R.color.priority_low;
                case PRIORITY_NORMAL:
                    return R.color.priority_normal;
                case PRIORITY_HIGH:
                    return R.color.priority_high;
                default:
                    return 0;
            }
        } else {
            switch (getPriority()){
                case PRIORITY_LOW:
                    return R.color.priority_low_selected;
                case PRIORITY_NORMAL:
                    return R.color.priority_normal_selected;
                case PRIORITY_HIGH:
                    return R.color.priority_high_selected;
                default:
                    return 0;
            }
        }

    }

    @Override
    public boolean isTask() {
        return true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
