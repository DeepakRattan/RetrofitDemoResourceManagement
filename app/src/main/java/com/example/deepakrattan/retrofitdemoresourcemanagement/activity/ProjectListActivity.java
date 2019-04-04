package com.example.deepakrattan.retrofitdemoresourcemanagement.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.deepakrattan.retrofitdemoresourcemanagement.R;
import com.example.deepakrattan.retrofitdemoresourcemanagement.adapter.ProjectListAdapter;
import com.example.deepakrattan.retrofitdemoresourcemanagement.model.Project;
import com.example.deepakrattan.retrofitdemoresourcemanagement.model.ProjectListResponse;
import com.example.deepakrattan.retrofitdemoresourcemanagement.network.APIClient;
import com.example.deepakrattan.retrofitdemoresourcemanagement.network.APIInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectListActivity extends AppCompatActivity {
    private APIInterface apiInterface;
    private RecyclerView rvProjects;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);

        rvProjects = findViewById(R.id.rvProjects);
        layoutManager = new LinearLayoutManager(this);
        rvProjects.setLayoutManager(layoutManager);

        /*Create handle for the APIInterface interface*/
        apiInterface = APIClient.getRetrofitInstance().create(APIInterface.class);
        Call<ProjectListResponse> call = apiInterface.getProjects();
        call.enqueue(new Callback<ProjectListResponse>() {
            @Override
            public void onResponse(Call<ProjectListResponse> call, Response<ProjectListResponse> response) {
                ProjectListResponse projectListResponse = response.body();
                String message = projectListResponse.getMessage();
                ArrayList<Project> projectArrayList = (ArrayList<Project>) projectListResponse.getResponseData();
                ProjectListAdapter adapter = new ProjectListAdapter(ProjectListActivity.this, projectArrayList);
                rvProjects.setAdapter(adapter);
                Toast.makeText(ProjectListActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ProjectListResponse> call, Throwable t) {

            }
        });
    }
}
