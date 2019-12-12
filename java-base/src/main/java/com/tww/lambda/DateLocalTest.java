package com.tww.lambda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-12-11 13:51
 */
public class DateLocalTest {

    public static void main(String[] args) {
        LocalDate dateLocal=LocalDate.of(1994,07,03);
        System.out.println(dateLocal);
        dateLocal=LocalDate.now();
        System.out.println(dateLocal);
        dateLocal= LocalDateTime.ofInstant(Instant.ofEpochMilli(new Date().getTime()), ZoneId.systemDefault()).toLocalDate().minus(1, ChronoUnit.MONTHS);
        System.out.println(dateLocal);
        dateLocal=dateLocal.plus(1,ChronoUnit.YEARS);
        System.out.println(dateLocal.isLeapYear());
        System.out.println(dateLocal);
        dateLocal.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();

    }
}
