package com.myproject.doseoro.global.error.exception;

public enum ErrorCode {
    // Common
    INVALID_TYPE_VALUE(400,"C001", "Invalid type Value"),
    INVALID_INPUT_VALUE(401, "C002", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C003", " Invalid Input Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),
    ENTITY_NOT_FOUND(407, "C007", "Entity not found"),
    INTERNAL_SERVER_ERROR(408, "C008", "Internal server error"),

    // Identity
    EMAIL_DUPLICATION(400, "I001", "Email is Duplicated"),
    LOGIN_INPUT_INVALID(400, "I002", "Login input is invalid");

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
