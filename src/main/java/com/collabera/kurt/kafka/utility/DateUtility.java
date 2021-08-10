package com.collabera.kurt.kafka.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
    public DateUtility() {}

    public static String formatDate(final Date date) {
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
    }
}
