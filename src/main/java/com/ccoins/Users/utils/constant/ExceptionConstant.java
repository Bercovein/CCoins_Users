package com.ccoins.Users.utils.constant;

public class ExceptionConstant {

    //LABELS
    public static final String ERROR_LABEL = "Error when trying to ";
    public static final String GET_ERROR_LABEL = ERROR_LABEL.concat("get ");
    public static final String CREATE_NEW_ERROR_LABEL = ERROR_LABEL.concat("create new ");
    public static final String FIND_ERROR_LABEL = ERROR_LABEL.concat("find ");

    //ERRORS
    public static final String GENERIC_ERROR_CODE = "0001";
    public static final String GENERIC_ERROR = "Something went wrong! Check with your administrator";


    public static final String USERS_NEW_OWNER_ERROR_CODE = "0002";
    public static final String USERS_NEW_OWNER_ERROR = CREATE_NEW_ERROR_LABEL.concat("owner");

    public static final String USERS_GET_OWNER_BY_EMAIL_ERROR_CODE = "0003";
    public static final String USERS_GET_OWNER_BY_EMAIL_ERROR = GET_ERROR_LABEL.concat("owner");

    public static final String USERS_FIND_OWNER_BY_EMAIL_ERROR_CODE = "0004";
    public static final String USERS_FIND_OWNER_BY_EMAIL_ERROR = FIND_ERROR_LABEL.concat("owner by email");

}
