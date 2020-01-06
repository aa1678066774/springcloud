package com.tww.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2020-01-02 13:57
 */
public class DateTest {
    public static void main(String[] args) {
        LocalDateTime dateTime=LocalDateTime.of(LocalDate.now(), LocalTime.MIN).minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTime.format(formatter));
    }
}
