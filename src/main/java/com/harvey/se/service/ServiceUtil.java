package com.harvey.se.service;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.harvey.se.pojo.vo.DateRange;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-11-08 09:03
 */
public class ServiceUtil {
    private ServiceUtil() {
    }

    public static <T> List<T> queryAndOrderWithDate(
            LambdaQueryChainWrapper<T> wrapper, SFunction<T, Date> dateColumn, DateRange dateRange, Page<T> page) {
        if (dateRange.isForward()) {
            wrapper.ge(dateRange.getFrom() != null, dateColumn, dateRange.getFrom())
                    .le(dateRange.getTo() != null, dateColumn, dateRange.getTo())
                    .orderByAsc(dateColumn, (SFunction<T, Date>[]) null);
        } else {
            wrapper.ge(dateRange.getTo() != null, dateColumn, dateRange.getTo())
                    .le(dateRange.getFrom() != null, dateColumn, dateRange.getFrom())
                    .orderByDesc(dateColumn, (SFunction<T, Date>[]) null);
        }
        return wrapper.page(page).getRecords();
    }
}
