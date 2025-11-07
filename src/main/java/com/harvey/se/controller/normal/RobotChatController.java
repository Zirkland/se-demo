package com.harvey.se.controller.normal;

import com.harvey.se.exception.UncompletedException;
import com.harvey.se.pojo.vo.Null;
import com.harvey.se.pojo.vo.Result;
import com.harvey.se.properties.ConstantsProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-11-08 00:14
 */
@Slf4j
@RestController
@Api(tags = "和LLM聊天的Controller")
@RequestMapping("/robot")
@EnableConfigurationProperties(ConstantsProperties.class)
public class RobotChatController {
    @PostMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ApiOperation(
            "用户问问题, LLM进行回答, 回答使用流式回答. 在回答期间, 用户再问问题, 问题将被忽略. 请客户端阻止用户问问题")
    @ApiResponse(code = 200, message = "将使用流式返回, 每一个返回都是 code data message, data格式再议")
    public Result<Null> streamChat(
            @RequestParam @ApiParam(value = "提出的问题, 自然语言", required = true) String question) {
        // 1. 用户的问题
        //      问题扩充: 携带用户自身的咨询信息
        // 2. 异步地:
        //      其返回内容和问题也要存在数据库
        // 3. 异步地:
        //      将question和message都异步地丢给ai, 让其生成结构化关键词
        //      (question->分析出用户关注的买车重点并提取关键词/answer->分析出其回答的买车重点并提取关键词)
        //      要求关键词是...的, 分词格式是....()
        throw new UncompletedException("向LLM发送请求并响应");
    }

}
