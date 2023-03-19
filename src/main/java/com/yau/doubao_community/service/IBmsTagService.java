package com.yau.doubao_community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yau.doubao_community.model.entity.BmsTag;

import java.util.List;

public interface IBmsTagService extends IService<BmsTag> {
    /**
     * 插入标签
     */
    List<BmsTag> insertTags(List<String> tags);
}
