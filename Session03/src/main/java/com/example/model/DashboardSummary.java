package com.example.model;

import java.util.Map;

public class DashboardSummary {
    private final int totalStudents;
    private final double averageGpa;
    private final Student topStudent;
    private final Map<String, Double> statusPercentages;

    public DashboardSummary(int totalStudents, double averageGpa, Student topStudent, Map<String, Double> statusPercentages) {
        this.totalStudents = totalStudents;
        this.averageGpa = averageGpa;
        this.topStudent = topStudent;
        this.statusPercentages = statusPercentages;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public double getAverageGpa() {
        return averageGpa;
    }

    public Student getTopStudent() {
        return topStudent;
    }

    public Map<String, Double> getStatusPercentages() {
        return statusPercentages;
    }
}

