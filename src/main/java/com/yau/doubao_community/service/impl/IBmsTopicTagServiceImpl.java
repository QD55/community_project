package com.yau.doubao_community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yau.doubao_community.mapper.BmsTopicTagMapper;
import com.yau.doubao_community.model.entity.BmsTopicTag;
import com.yau.doubao_community.service.IBmsTopicTagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBmsTopicTagServiceImpl extends ServiceImpl<BmsTopicTagMapper, BmsTopicTag>
        implements IBmsTopicTagService {

    @Override
    public List<BmsTopicTag> selectByTopicId(String topicId) {
        QueryWrapper<BmsTopicTag> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BmsTopicTag::getTopicId, topicId);
        return this.baseMapper.selectList(wrapper);
    }
}
