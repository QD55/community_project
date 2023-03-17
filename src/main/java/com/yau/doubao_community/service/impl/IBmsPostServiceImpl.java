package com.yau.doubao_community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yau.doubao_community.mapper.BmsTagMapper;
import com.yau.doubao_community.mapper.BmsTopicMapper;
import com.yau.doubao_community.model.entity.BmsPost;
import com.yau.doubao_community.model.entity.BmsTag;
import com.yau.doubao_community.model.entity.BmsTopicTag;
import com.yau.doubao_community.model.vo.PostVO;
import com.yau.doubao_community.service.IBmsPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IBmsPostServiceImpl  extends ServiceImpl<BmsTopicMapper, BmsPost> implements IBmsPostService {
    @Resource
    private BmsTagMapper bmsTagMapper;

    @Autowired
    private com.yau.doubao_community.service.IBmsTopicTagService IBmsTopicTagService;
    @Override
    public Page<PostVO> getList(Page<PostVO> page, String tab) {
        // 查询话题
        Page<PostVO> iPage = this.baseMapper.selectListAndPage(page, tab);
        // 查询话题的标签
        iPage.getRecords().forEach(topic -> {
            List<BmsTopicTag> topicTags = IBmsTopicTagService.selectByTopicId(topic.getId());
            if (!topicTags.isEmpty()) {
                List<String> tagIds = topicTags.stream().map(BmsTopicTag::getTagId).collect(Collectors.toList());
                List<BmsTag> tags = bmsTagMapper.selectBatchIds(tagIds);
                topic.setTags(tags);
            }
        });
        return iPage;
    }
}