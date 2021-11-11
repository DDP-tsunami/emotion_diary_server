package com.dadaepo.emo.util;

import java.time.LocalDate;
import java.util.Date;

public class DateUtil {

    private DateUtil(){
    }

    public static LocalDate getToday() {
        LocalDate todayDate = LocalDate.now();
        return todayDate;
    }
}
