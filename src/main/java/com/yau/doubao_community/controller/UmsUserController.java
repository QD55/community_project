package com.yau.doubao_community.controller;

import com.yau.doubao_community.common.api.ApiResult;
import com.yau.doubao_community.common.exception.ApiAsserts;
import com.yau.doubao_community.model.dto.LoginDTO;
import com.yau.doubao_community.model.dto.RegisterDTO;
import com.yau.doubao_community.model.entity.UmsUser;
import com.yau.doubao_community.service.IUmsUserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ums/user")
public class UmsUserController extends BaseController{

    @Resource
    private IUmsUserService iUmsUserService;

    /**
     * 用户注册
     * @param dto
     * @return
     */
    @PostMapping("/register")
    public ApiResult<Map<String, Object>> register(@Valid @RequestBody RegisterDTO dto) {
        UmsUser user = iUmsUserService.executeRegister(dto);
        if (ObjectUtils.isEmpty(user)) {
            return ApiResult.failed("注册失败");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        return ApiResult.success(map);
    }

    @PostMapping("/login")
    public ApiResult<Map<String, String>> login(@Valid @RequestBody LoginDTO dto) {
        String token = iUmsUserService.executeLogin(dto);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("账号或密码错误");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("token", token);
        return ApiResult.success(map, "登陆成功");
    }
}
