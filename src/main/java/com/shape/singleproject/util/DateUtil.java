package com.shape.singleproject.util;

import com.google.common.collect.Lists;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * 时间操作类
 */
public class DateUtil {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static String getNowDateString() {
        return dateFormatter.format(LocalDateTime.now());
    }

    public static String getDateString(LocalDateTime localDateTime) {
        return dateFormatter.format(localDateTime);
    }

    public static String getDateTimeString(LocalDateTime localDateTime) {
        return dateTimeFormatter.format(localDateTime);
    }

    public static String getTimeString(LocalDateTime localDateTime) {
        return timeFormatter.format(localDateTime);
    }

    public static String getDateString(LocalDateTime date, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter.format(date);
    }

    public static List<String> generateDateDaySequence(LocalDateTime date, Integer size) {
        LocalDateTime temp = LocalDateTime.from(date);
        List<String> list = Lists.newArrayList();
        for (int i =0; i< size; i++) {
            list.add(dateFormatter.format(temp));
            temp = temp.minusDays(1);
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(timeFormatter.format(LocalDateTime.now()));
    }
}
