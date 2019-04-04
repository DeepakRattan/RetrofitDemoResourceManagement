package com.example.deepakrattan.retrofitdemoresourcemanagement.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EmployeeList {
    @SerializedName("employeeList")
    ArrayList<Employee> employeeArrayList;

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }
}
