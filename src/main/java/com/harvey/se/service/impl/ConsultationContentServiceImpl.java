package com.harvey.se.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harvey.se.dao.ConsultationContentMapper;
import com.harvey.se.pojo.dto.ConsultationContentDto;
import com.harvey.se.pojo.dto.ConsultationContentWithUserEntityDto;
import com.harvey.se.pojo.entity.ConsultationContent;
import com.harvey.se.pojo.entity.User;
import com.harvey.se.service.ConsultationContentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-11-08 06:55
 * @see ConsultationContent
 * @see ConsultationContentMapper
 * @see ConsultationContentService
 */
@Service
public class ConsultationContentServiceImpl extends
        ServiceImpl<ConsultationContentMapper, ConsultationContent> implements ConsultationContentService {
    @Override
    public ConsultationContentDto queryByUser(Long userId) {
        return new ConsultationContentDto(getById(userId));
    }

    @Override
    public List<ConsultationContentDto> queryByPage(Page<ConsultationContent> page) {
        return new LambdaQueryChainWrapper<>(baseMapper).page(page)
                .getRecords()
                .stream()
                .map(ConsultationContentDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConsultationContentWithUserEntityDto> combineWithUsers(List<User> userList) {
        List<Long> userIds = userList.stream().map(User::getId).collect(Collectors.toList());
        Map<Long, ConsultationContent> consultationContentMap = new LambdaQueryChainWrapper<>(baseMapper).in(
                        ConsultationContent::getUserId,
                        userIds
                )
                .list()
                .stream()
                .collect(Collectors.toMap(ConsultationContent::getUserId, e -> e));
        return userList.stream()
                .map(user -> ConsultationContentWithUserEntityDto.instance(Optional.ofNullable(consultationContentMap.get(
                        user.getId())).orElse(ConsultationContent.DEFAULT), user))
                .collect(Collectors.toList());
    }


}