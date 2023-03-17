package com.yau.doubao_community.controller;

import com.yau.doubao_community.common.api.ApiResult;
import com.yau.doubao_community.model.dto.LoginDTO;
import com.yau.doubao_community.model.dto.RegisterDTO;
import com.yau.doubao_community.model.entity.UmsUser;
import com.yau.doubao_community.service.IUmsUserService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.yau.doubao_community.jwt.JwtUtil.USER_NAME;
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

    /**
     * 用户登录
     * @param dto
     * @return
     */
    @PostMapping("/login")
    public ApiResult<Map<String, String>> login(@Valid @RequestBody LoginDTO dto) {
        String token = iUmsUserService.executeLogin(dto);
        if (ObjectUtils.isEmpty(token)) {
            return ApiResult.failed("账号或密码错误");
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("token", token);
        return ApiResult.success(map, "登录成功");
    }

    @GetMapping("/info")
    public ApiResult<UmsUser> getUser(@RequestHeader(value = USER_NAME) String userName) {
        System.out.println(userName);
        UmsUser user = iUmsUserService.getUserByUsername(userName);
        return ApiResult.success(user);
    }

    @GetMapping("/logout")
    public ApiResult<Object> logOut() {
        return ApiResult.success("退出登录成功");
    }
}
