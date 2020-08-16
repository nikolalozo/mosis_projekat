package com.mosis.jobify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mosis.jobify.data.JobsData;
import com.mosis.jobify.data.UsersData;
import com.mosis.jobify.models.Job;
import com.mosis.jobify.models.JobRequestListItem;
import com.mosis.jobify.models.User;

import java.util.ArrayList;

public class JobRequestsFragment extends Fragment {
    private static final String TAG = "com.mosis.jobify.JobRequestsFragment";
    private Button btnTEST;
    private ArrayList<Job> jobs;
    ListView lvJobRequests;
    public ArrayAdapter adapterJobRequests;
    public ArrayList row;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        jobs = JobsData.getInstance().getJobRequestsForUser(UsersData.getInstance().getCurrentUser().getuID());
        View view = inflater.inflate(R.layout.jobrequests_fragment, container, false);
        btnTEST = (Button) view.findViewById((R.id.btnTEST2));
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).arrayIdRequested != null) {
                for (int j = 0; j < jobs.get(i).arrayIdRequested.size(); j++) {
                    User user = UsersData.getInstance().getUser(jobs.get(i).arrayIdRequested.get(j));
                    JobRequestListItem jobRequestListItem = new JobRequestListItem(user, jobs.get(i).getKey(), jobs.get(i).getTitle(),jobs.get(i).getDate());
                    row.add(jobRequestListItem);
                }
            }
        }
        lvJobRequests = (ListView) view.findViewById((R.id.lvJobRequests));
        adapterJobRequests = new ArrayAdapter(getActivity(), R.layout.list_item, row);
        lvJobRequests.setAdapter(adapterJobRequests);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 2",Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }

}
