package com.example.real_estate_company.mahhi;

import java.io.Serializable;

public class ProjectData implements Serializable {
    private String projectName;
    private String deadline;
    private double progress; // Value between 0.0 and 1.0

    public ProjectData(String projectName, String deadline, double progress) {
        this.projectName = projectName;
        this.deadline = deadline;
        this.progress = progress;
    }

    public String getProjectName() { return projectName; }
    public String getDeadline() { return deadline; }
    public double getProgress() { return progress; }
}
