package com.yau.doubao_community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yau.doubao_community.model.dto.CommentDTO;
import com.yau.doubao_community.model.entity.BmsComment;
import com.yau.doubao_community.model.entity.UmsUser;
import com.yau.doubao_community.model.vo.CommentVO;

import java.util.List;

public interface IBmsCommentService extends IService<BmsComment> {

    /**
     *  获取评论信息
     *
     * @param topicid
     * @return {@link BmsComment}
     */
    List<CommentVO> getCommentsByTopicID(String topicid);

    /**
     *  添加评论
     * @param dto
     * @param user
     * @return
     */
    BmsComment create(CommentDTO dto, UmsUser user);
}
