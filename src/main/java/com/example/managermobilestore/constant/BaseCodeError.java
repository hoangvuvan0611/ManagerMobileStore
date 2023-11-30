package com.example.managermobilestore.constant;

public class BaseCodeError {
    public static final int OTHER = 1;
    public static final int VALIDATION_ERROR = 2;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int TOKEN_REQUIRED = 405;
    public static final int REQUEST_TIME_OUT = 408;
    public static final int SERVER_ERROR = 500;
    public static final int GATEWAY_TIME_OUT = 504;

    public static final String getErrMsg(int code) {
        switch (code) {
            case OTHER:
                return "Other Error";
            case VALIDATION_ERROR:
                return "Parameter is valid!";
            case SERVER_ERROR:
                return "Server error!";
            case BAD_REQUEST:
                return "Bad request!";
            case NOT_FOUND:
                return "Not found!";
            default:
                return "Unexplainable";
        }
    }
}
