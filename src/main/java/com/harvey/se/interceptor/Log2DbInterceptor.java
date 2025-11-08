package com.harvey.se.interceptor;

import com.harvey.se.pojo.entity.UserActionLog;
import com.harvey.se.service.UserActionLogService;
import com.harvey.se.util.ClientIpUtil;
import com.harvey.se.util.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 * 创建用户请求日志, 并将其存入数据库
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-11-8 12:32
 */
@Slf4j
@Component
public class Log2DbInterceptor implements HandlerInterceptor {
    private static final String REQUEST_START_TIME = "request-start-time";
    @Resource
    private UserActionLogService userActionLogService;


    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute(REQUEST_START_TIME, System.currentTimeMillis());
        return true;// 总是放过
    }


    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Object attribute = request.getAttribute(REQUEST_START_TIME);
        if (!(attribute instanceof Long)) {
            throw new IllegalStateException("expect timestamp (long) in request attribute " + REQUEST_START_TIME);
        }
        Date requestDate = new Date((Long) attribute);
        UserActionLog userActionLog = new UserActionLog(
                null,
                UserHolder.existUser() ? UserHolder.currentUserId() : null,
                ClientIpUtil.get(request),
                request.getRequestURI(),
                request.getMethod().toUpperCase(),
                requestDate,
                (int) (System.currentTimeMillis() - requestDate.getTime())
        );
        userActionLogService.syncInsert(userActionLog);
    }
}
