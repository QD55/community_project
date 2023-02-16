package com.yau.doubao_community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yau.doubao_community.mapper.BmsBillboardMapper;
import com.yau.doubao_community.model.entity.BmsBillboard;
import com.yau.doubao_community.service.IBmsBillboardService;
import org.springframework.stereotype.Service;

@Service
public class IBmsBillboardServiceImpl extends ServiceImpl<BmsBillboardMapper, BmsBillboard>
        implements IBmsBillboardService {
}
