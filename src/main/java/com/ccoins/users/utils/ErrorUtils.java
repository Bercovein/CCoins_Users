package com.ccoins.users.utils;

import com.ccoins.users.dto.ExceptionRsDTO;

public class ErrorUtils {

    private ErrorUtils() {
    }

    public static ExceptionRsDTO buildMessage(String code, Object message){

        return ExceptionRsDTO.builder().code(code).message(message).build();
    }

}
