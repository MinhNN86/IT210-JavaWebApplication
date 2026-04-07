package com.example.model;

public enum StudentStatus {
    STUDYING("Dang hoc", "status-studying"),
    DEFERRED("Bao luu", "status-deferred"),
    GRADUATED("Tot nghiep", "status-graduated");

    private final String label;
    private final String cssClass;

    StudentStatus(String label, String cssClass) {
        this.label = label;
        this.cssClass = cssClass;
    }

    public String getLabel() {
        return label;
    }

    public String getCssClass() {
        return cssClass;
    }
}

