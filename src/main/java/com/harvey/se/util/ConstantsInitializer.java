package com.harvey.se.util;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.harvey.se.properties.ConstantsProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 依据常量的初始化工具
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-20 18:19
 */
@Component
public class ConstantsInitializer {
    @Resource
    private ConstantsProperties constantsProperties;

    public <T> Page<T> initPage(Integer page, Integer limit) {
        if (page == null) {
            page = 1;
        }
        if (limit == null || limit > Integer.parseInt(constantsProperties.getMaxPageSize())) {
            limit = Integer.valueOf(constantsProperties.getDefaultPageSize());
        }
        return new Page<>(page, limit);
    }
}
