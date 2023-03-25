package com.yau.doubao_community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yau.doubao_community.model.entity.BmsComment;
import com.yau.doubao_community.model.vo.CommentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BmsCommentMapper extends BaseMapper<BmsComment> {

    /**
     *  获取评论
     * @param topicid
     * @return
     */
    List<CommentVO> getCommentsByTopicID(@Param("topicid") String topicid);
}
