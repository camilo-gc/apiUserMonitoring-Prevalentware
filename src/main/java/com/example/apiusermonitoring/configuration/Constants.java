package com.example.apiusermonitoring.configuration;


public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }


    public static final String ADMIN_ROLE ="Admin";
    public static final String MANAGER_ROLE ="Manager";
    public static final String USER_ROLE ="User";

    public static final String REGEX_DATE_FORMAT = "^([0-9]{4}-((0[13-9]|1[012])-(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])-31|02-(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)-02-29)$";

    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String ACCESS_DENIED_MESSAGE = "acceso denegado";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String NO_EMPTY_MESSAGE = "Must not be empty";
    public static final String USER_NOT_FOUND_MESSAGE = "No user has been found with the provided email address";
    public static final String INVALID_DATE_FORMAT_MESSAGE ="Invalid date format, must have the following format 'yyyy-MM-dd'";
    public static final String INVALID_DATE_RANGE_MESSAGE ="The start date cannot be greater than the end date";
    public static final String INVALID_TOKEN_MESSAGE ="A problem with the token has occurred";
    public static final String ROLE_NOT_FOUND_MESSAGE ="A problem with the token has occurred";

}
