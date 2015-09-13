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

    public TabAdapter(FragmentManager fm, Context context) {
        super(fm);

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
                return new CurrentTaskFragment();
            case 1:
                return new DoneTaskFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
