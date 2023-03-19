package com.yau.doubao_community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yau.doubao_community.mapper.BmsFollowMapper;
import com.yau.doubao_community.model.entity.BmsFollow;
import com.yau.doubao_community.service.IBmsFollowService;
import org.springframework.stereotype.Service;

@Service
public class IBmsFollowServiceImpl extends ServiceImpl<BmsFollowMapper, BmsFollow> implements IBmsFollowService {
}
