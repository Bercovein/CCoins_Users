package com.ccoins.users.utils;

import java.time.LocalDateTime;

public class DateUtils {

    public static final String AUTO_DATE = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP";

    public static LocalDateTime now(){
        return LocalDateTime.now();
    }
}
