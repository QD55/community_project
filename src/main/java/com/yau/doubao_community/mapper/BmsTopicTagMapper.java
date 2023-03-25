package com.yau.doubao_community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yau.doubao_community.model.entity.BmsTopicTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BmsTopicTagMapper extends BaseMapper<BmsTopicTag> {

    Set<String> getTopicIdsByTagId(@Param("id") String id);
}
