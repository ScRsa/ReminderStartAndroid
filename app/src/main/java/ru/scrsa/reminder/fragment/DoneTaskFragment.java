package ru.scrsa.reminder.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.scrsa.reminder.R;


public class DoneTaskFragment extends Fragment {

    private RecyclerView rvCurrentTask;
    private RecyclerView.LayoutManager layoutManager;


    public DoneTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_task, container, false);

        rvCurrentTask = (RecyclerView) view.findViewById(R.id.rvCurrentTask);

        layoutManager = new LinearLayoutManager(getActivity());

        rvCurrentTask.setLayoutManager(layoutManager);

        return view;
    }


}
