package io.github.debz_cpu.restserver.http;

public enum HttpStatus {
    OK(200, "OK"),
    CREATED(201,"Created"),
    ACCEPTED(202,"Accepted"),
    NO_CONTENT(204,"No Content"),
    BAD_REQUEST(400,"Bad Request"),
    UNAUTHORIZED(401,"Unauthorized"),
    NOT_FOUND(404,"Not Found"),
    METHOD_NOT_ALLOWED(405,"Method Not Allowed"),
    CONFLICT(409,"Conflict"),
    INTERNAL_SERVER_ERROR(500,"Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented");

    private final int code;
    private final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
