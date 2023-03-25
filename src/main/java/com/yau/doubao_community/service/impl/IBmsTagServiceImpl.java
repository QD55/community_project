package com.yau.doubao_community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yau.doubao_community.mapper.BmsTagMapper;
import com.yau.doubao_community.model.entity.BmsPost;
import com.yau.doubao_community.model.entity.BmsTag;
import com.yau.doubao_community.service.IBmsPostService;
import com.yau.doubao_community.service.IBmsTagService;
import com.yau.doubao_community.service.IBmsTopicTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class IBmsTagServiceImpl extends ServiceImpl<BmsTagMapper, BmsTag> implements IBmsTagService {

    @Autowired
    private IBmsPostService iBmsPostService;

    @Autowired
    private IBmsTopicTagService iBmsTopicTagService;

    @Override
    public List<BmsTag> insertTags(List<String> tagNames) {
        List<BmsTag> tagList = new ArrayList<>();
        for (String tagName : tagNames) {
            BmsTag tag = this.baseMapper.selectOne(new LambdaQueryWrapper<BmsTag>().eq(BmsTag::getName, tagName));
            if (tag == null) {
                tag = BmsTag.builder().name(tagName).build();
                this.baseMapper.insert(tag);
            } else {
                tag.setTopicCount(tag.getTopicCount() + 1);
                this.baseMapper.updateById(tag);
            }
            tagList.add(tag);
        }
        return tagList;
    }

    @Override
    public Page<BmsPost> selectTopicsByTagId(Page<BmsPost> topicPage, String id) {
        // 获取关联的话题ID
        Set<String> ids = iBmsTopicTagService.selectTopicIdsByTagId(id);
        LambdaQueryWrapper<BmsPost> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(BmsPost::getId, ids);

        return iBmsPostService.page(topicPage, wrapper);
    }

}
