package com.mosis.jobify.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.mosis.jobify.R;
import com.mosis.jobify.UserListAdapter;
import com.mosis.jobify.data.UsersData;
import com.mosis.jobify.models.Job;
import com.mosis.jobify.models.User;

import java.util.ArrayList;

public class UserRequestsActivity extends AppCompatActivity {
    ArrayList<String> idRequests;
    ArrayList<User> users = new ArrayList<User>();
    ListView lvUserRequests;
    Job job;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_requests);
        lvUserRequests = (ListView) findViewById((R.id.lvUserRequests));
        toolbar = findViewById(R.id.toolbarUserRequests);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idRequests = (ArrayList<String>) extras.get("array");
            job = (Job) extras.get("job");
            for (int i = 0; i < idRequests.size(); i++) {
                User user = UsersData.getInstance().getUser(idRequests.get(i));
                users.add(user);
            }
            lvUserRequests.setAdapter(new UserListAdapter(this, R.layout.layout_user_list_item, users, job));
        }
    }
}
