package com.yau.doubao_community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yau.doubao_community.model.entity.BmsTip;


public interface IBmsTipService extends IService<BmsTip> {
    BmsTip getRandomToday();
}
