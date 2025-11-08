package com.harvey.se.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.harvey.se.dao.GiftMapper;
import com.harvey.se.pojo.dto.GiftInfoDto;
import com.harvey.se.pojo.entity.Gift;
import com.harvey.se.service.GiftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-11-08 06:55
 * @see Gift
 * @see GiftMapper
 * @see GiftService
 */
@Slf4j
@Service
public class GiftServiceImpl extends ServiceImpl<GiftMapper, Gift> implements GiftService {

    @Override
    public void insert(GiftInfoDto giftInfoDto) {
        Gift gift = new Gift(giftInfoDto);
        gift.setId(null);
        int insert = baseMapper.insert(gift);
        if (insert <= 0) {
            log.warn("插入 {} 失败", gift);
        }
    }

    @Override
    public void delete(Long id) {
        boolean removed = super.removeById(id);
        if (!removed) {
            log.warn("删除gift {} 失败", id);
        }
    }

    @Override
    public void update(GiftInfoDto giftInfoDto) {
        Gift gift = new Gift(giftInfoDto);
        boolean updated = super.updateById(gift);
        if (!updated) {
            log.warn("更新 {} 失败", gift);
        }
    }
}