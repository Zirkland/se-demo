package com.harvey.se.service;

import com.harvey.se.pojo.dto.UserDto;

import java.util.concurrent.TimeUnit;

/**
 * 积分接口, 本身与SQL无关
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-11-08 01:07
 */
public interface PointService {

    void add(String keyPre, UserDto user, int point, int timeout, TimeUnit unit);
}
