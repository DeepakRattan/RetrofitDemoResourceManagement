package com.example.deepakrattan.retrofitdemoresourcemanagement.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.deepakrattan.retrofitdemoresourcemanagement.R;
import com.example.deepakrattan.retrofitdemoresourcemanagement.model.Project;

import java.util.ArrayList;


/**
 * Created by deepak.rattan on 5/7/2018.
 */

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectViewHolder> {
    private Context context;
    private ArrayList<Project> projectArrayList;


    public ProjectListAdapter(Context context, ArrayList<Project> projectArrayList) {
        this.context = context;
        this.projectArrayList = projectArrayList;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_project_list, parent, false);
        ProjectViewHolder viewHolder = new ProjectViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        Project project = projectArrayList.get(position);
        if (project.getTitle() != null && project.getDescription() != null) {
            holder.txtProjectName.setText(project.getTitle());
            holder.txtProjectDesc.setText(project.getDescription());
        }


    }

    @Override
    public int getItemCount() {
        return projectArrayList.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {
        TextView txtProjectName, txtProjectDesc;

        public ProjectViewHolder(View itemView) {
            super(itemView);
            txtProjectName = itemView.findViewById(R.id.txtProjectName);
            txtProjectDesc = itemView.findViewById(R.id.txtProjectDescription);

        }
    }

}
