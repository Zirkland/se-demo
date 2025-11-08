package com.harvey.se.service.impl;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harvey.se.dao.HotWordMapper;
import com.harvey.se.exception.UncompletedException;
import com.harvey.se.pojo.dto.HotWordDto;
import com.harvey.se.pojo.entity.HotWord;
import com.harvey.se.service.HotWordService;
import com.harvey.se.util.ConstantsInitializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-11-08 06:56
 * @see HotWord
 * @see HotWordMapper
 * @see HotWordService
 */
@Service
public class HotWordServiceImpl extends ServiceImpl<HotWordMapper, HotWord> implements HotWordService {
    @Resource
    private ConstantsInitializer constantsInitializer;

    @Override
    public List<HotWordDto> top(Integer limit) {
        return new LambdaQueryChainWrapper<>(baseMapper).orderByDesc(
                        HotWord::getFrequency,
                        (SFunction<HotWord, ?>[]) null
                )
                .page(constantsInitializer.initPage(1, limit))
                .getRecords()
                .stream()
                .map(HotWordDto::adapte)
                .collect(Collectors.toList());
    }

    @Override
    public List<HotWord> batchInsert(List<String> keywords) {
        throw new UncompletedException("batch insert keywords");
    }
}