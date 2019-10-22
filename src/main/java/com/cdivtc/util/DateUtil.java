package com.cdivtc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String dateToWeek(String datetime) throws java.text.ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "日", "一", "二", "三", "四", "五", "六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        datet = (Date) f.parse(datetime);
        cal.setTime(datet);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        System.out.println(weekDays[w]);//星期二
        return weekDays[w];
    }

}
