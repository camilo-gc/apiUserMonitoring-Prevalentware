package com.example.apiusermonitoring.configuration;


public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String NO_EMPTY_MESSAGE = "must not be empty";
    public static final String USER_NOT_FOUND_MESSAGE = "No user has been found with the provided email address";

}
