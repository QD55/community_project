package com.yau.doubao_community.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yau.doubao_community.model.dto.CreateTopicDTO;
import com.yau.doubao_community.model.entity.BmsPost;
import com.yau.doubao_community.model.entity.UmsUser;
import com.yau.doubao_community.model.vo.PostVO;

import java.util.List;
import java.util.Map;

public interface IBmsPostService extends IService<BmsPost> {

    /**
     * 获取首页话题列表
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> getList(Page<PostVO> page, String tab);

    /**
     * 发布帖子
     * @param dto
     * @param user
     * @return
     */
    BmsPost create(CreateTopicDTO dto, UmsUser user);

    /**
     * 查看帖子详情
     * @param id
     * @return
     */
    Map<String, Object> viewTopic(String id);

    /**
     * 获取随机推荐10篇
     * @param id
     * @return
     */
    List<BmsPost> getRecommend(String id);
}
