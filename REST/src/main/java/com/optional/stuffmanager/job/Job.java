package com.optional.stuffmanager.job;

public enum Job {
    CEO("CEO"),
    CTO("CTO"),
    MANAGER("Manager"),
    ACCOUNTANT("Accountant"),
    OFFICEWORKER("Office Worker"),
    CLEANER("Cleaner"),
    SECURITYGUARD("Security Guard");

    private final String fieldName;

    Job(String fieldName) { this.fieldName = fieldName; }

    public String getFieldName() { return fieldName; }
}
