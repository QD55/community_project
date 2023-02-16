package com.yau.doubao_community.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yau.doubao_community.common.api.ApiResult;
import com.yau.doubao_community.model.entity.BmsBillboard;
import com.yau.doubao_community.service.IBmsBillboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/billboard")
public class BmsBillboardController extends BaseController{

    @Autowired
    private IBmsBillboardService iBmsBillboardService;

    @GetMapping("/show")
    public ApiResult<BmsBillboard> getNotices() {
        List<BmsBillboard> list = iBmsBillboardService.list(
                new LambdaQueryWrapper<BmsBillboard>().eq(BmsBillboard::isShow, true));
        return ApiResult.success(list.get(list.size() - 1));
    }

}
