package com.harvey.se;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * TODO
 * 排行榜
 * A. 如果真要实现
 *      Redis存储国家id-国家得票,得票作为score
 *      Redis只保存前100/前200(国家最多200个, 所以全存也没事), 前端显示的可能可以更少
 *      依据id增加score, 使用遍历查询, 由于200个这个量级, 遍历也没事zIncrBy stu -1 Amy(其实log(N), skip list)
 *      每次投票改变, 使用异步写数据库
 *      固定时间(2-3分钟, 甚至半小时也是可以接受的)从数据库获取数据, 刷新一下Redis
 * B. Fake
 *      就count++. 要不然使用AtomicInteger
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-11-04 20:05
 */
@MapperScan(basePackages = "com.harvey.se.dao")
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class SeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeDemoApplication.class, args);
    }

}
