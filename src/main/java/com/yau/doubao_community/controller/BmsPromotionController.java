package com.yau.doubao_community.controller;

import com.yau.doubao_community.common.api.ApiResult;
import com.yau.doubao_community.model.entity.BmsPromotion;
import com.yau.doubao_community.service.IBmsPromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/promotion")
public class BmsPromotionController extends BaseController{

    @Resource
    private IBmsPromotionService bmsPtomotionService;

    @GetMapping("/all")
    public ApiResult<List<BmsPromotion>> getPromotion() {
        List<BmsPromotion> list = bmsPtomotionService.list();
        return ApiResult.success(list);
    }

}
