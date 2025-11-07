package com.harvey.se.controller.normal;

import com.harvey.se.exception.UncompletedException;
import com.harvey.se.pojo.dto.ConsultationContentDto;
import com.harvey.se.pojo.vo.Result;
import com.harvey.se.properties.ConstantsProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-11-08 01:42
 */
@Slf4j
@RestController
@Api(tags = "用户购车需求咨询")
@RequestMapping("/consultation-content")
@EnableConfigurationProperties(ConstantsProperties.class)
public class ConsultationContentController {
    @GetMapping(value = "/me")
    @ApiOperation("查询自己的购车咨询信息")
    @ApiResponse(code = 200, message = "如果未设置, 则返回默认的")
    public Result<ConsultationContentDto> consultationByUser() {
        // 查询自己的购车需求
        // 如果还没有, 就返回默认的
        throw new UncompletedException("查询自己的购车咨询信息");
    }

    @PutMapping(value = "/update")
    @ApiOperation("更新自己的购车咨询信息, 如果未设置, 则insert")
    public Result<ConsultationContentDto> update(
            @RequestBody @ApiParam(value = "如果某个字段是null, 则会被认为保持原状, 不进行更新.", required = true)
            ConsultationContentDto consultationContentDto) {
        // 更新自己的购车需求
        // 如果还没有, 就插入
        throw new UncompletedException("更新本用户的购车咨询信息");
    }
}
