package com.yau.doubao_community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yau.doubao_community.model.entity.BmsTopicTag;

import java.util.List;

public interface IBmsTopicTagService extends IService<BmsTopicTag> {
    /**
     * 获取Topic Tag 关联记录
     *
     * @param topicId TopicId
     * @return
     */
    List<BmsTopicTag> selectByTopicId(String topicId);
}
