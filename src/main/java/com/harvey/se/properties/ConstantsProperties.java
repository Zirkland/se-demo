package com.harvey.se.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2024-02-04 17:28
 */
@Data
@ConfigurationProperties(prefix = "h-se.constants")
public class ConstantsProperties {
    public static final String AUTHORIZATION_HEADER = "authorization";
    public static final String RESTRICT_REQUEST_TIMES = "7";
    public static final Set<String> ROOT_AUTH_URI = Set.of("/user/create");
    public static final String MAX_PAGE_SIZE = "30";
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final long CLEAR_CLICK_HISTORY_WAIT_MILLIONS = 10 * 60 * 1000;
    private String authorizationHeader = "authorization";
    private String restrictRequestTimes = RESTRICT_REQUEST_TIMES;
    private String clearClickHistoryWaitSeconds = String.valueOf(CLEAR_CLICK_HISTORY_WAIT_MILLIONS);
    private String maxPageSize = MAX_PAGE_SIZE;
    private String defaultPageSize = DEFAULT_PAGE_SIZE;
    private String redisHost;
    private String redisPassword;
}
