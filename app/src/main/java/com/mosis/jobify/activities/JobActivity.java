package com.mosis.jobify.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mosis.jobify.R;
import com.mosis.jobify.data.UsersData;
import com.mosis.jobify.models.Job;
import com.mosis.jobify.models.User;

import java.text.DateFormat;
import java.util.Locale;

public class JobActivity extends AppCompatActivity {
    Job job;
    TextView tvJobTitle, tvPay, tvDate, tvDescription, tvPostedDate, tvApplyBy, tvHour, tvPerson;
    Button btnViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Job details");
        tvJobTitle = findViewById(R.id.tvTitle);
        tvPay = findViewById(R.id.pay);
        tvDate = findViewById(R.id.tvDate);
        tvDescription = findViewById(R.id.tvDescription);
        tvPostedDate = findViewById(R.id.publishedDate);
        tvApplyBy = findViewById(R.id.applyByDate);
        tvHour = findViewById(R.id.tvHour);
        tvPerson = findViewById(R.id.tvOwner);
        btnViewProfile = findViewById(R.id.btnViewProfile);
        tvHour.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_hourglass, 0, 0, 0);
        Bundle extras = getIntent().getExtras();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault());
        if (extras != null) {
            job = (Job) extras.get("job");
            tvJobTitle.setText(job.getTitle());
            tvPay.setText(job.getWage() + "RSD");
            tvDate.setText("Date: " + dateFormat.format(job.getDate()));
            tvDescription.setText(job.getDescription());
            tvPostedDate.setText(dateFormat.format(job.getDatePosted()));
            tvApplyBy.setText(dateFormat.format(job.getAppliedBy()));
            tvHour.setText(timeFormat.format(job.getDate()));
            tvPerson.setText(UsersData.getInstance().getUser(job.getIdPosted()).fullName());
            btnViewProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", UsersData.getInstance().getUser(job.getIdPosted()));
                    Intent i = new Intent(JobActivity.this, ProfileActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            });
        }


    }
}
