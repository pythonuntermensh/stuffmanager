package com.optional.stuffmanager.role;

public enum Role {
    CEO("CEO"),
    CTO("CTO"),
    MANAGER("Manager"),
    ACCOUNTANT("Accountant"),
    OFFICEWORKER("Office Worker"),
    CLEANER("Cleaner"),
    SECURITYGUARD("Security Guard");

    private final String fieldName;

    Role(String fieldName) { this.fieldName = fieldName; }

    public String getFieldName() { return fieldName; }
}
