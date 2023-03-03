package com.yau.doubao_community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yau.doubao_community.mapper.BmsTipMapper;
import com.yau.doubao_community.model.entity.BmsTip;
import com.yau.doubao_community.service.IBmsTipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IBmsTipServiceImpl extends ServiceImpl<BmsTipMapper, BmsTip> implements IBmsTipService {
    @Override
    public BmsTip getRandomToday() {
        BmsTip todayTip = null;
        try {
            todayTip = this.baseMapper.getRandomTip();
        } catch (Exception e) {
            log.info("转换失败");
        }
        return todayTip;
    }
}
