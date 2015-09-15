package ru.scrsa.reminder.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ru.scrsa.reminder.R;
import ru.scrsa.reminder.fragment.CurrentTaskFragment;
import ru.scrsa.reminder.fragment.DoneTaskFragment;

public class TabAdapter extends FragmentPagerAdapter {

    private String[] tabs;

    public static final int CURRENT_TASK_FRAGMENT_POSITION = 0;
    public static final int DONE_TASK_FRAGMENT_POSITION = 1;

    private CurrentTaskFragment currentTaskFragment;
    private DoneTaskFragment doneTaskFragment;

    public TabAdapter(FragmentManager fm, Context context) {
        super(fm);

        currentTaskFragment = new CurrentTaskFragment();
        doneTaskFragment = new DoneTaskFragment();

        tabs = new String[] {
                context.getString(R.string.current_task_tab),
                context.getString(R.string.done_task_tab)
        };
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return currentTaskFragment;
            case 1:
                return doneTaskFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
