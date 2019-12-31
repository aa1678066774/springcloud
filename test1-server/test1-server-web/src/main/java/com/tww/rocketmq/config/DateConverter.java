package com.tww.rocketmq.config;

import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @program: root
 * @description:
 * @author: weiweiTang
 * @create: 2019-07-04 16:41
 */
public class DateConverter implements Converter<Long, LocalDate> {
    @Override
    public LocalDate convert(Long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
