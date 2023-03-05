package com.yau.doubao_community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yau.doubao_community.model.dto.LoginDTO;
import com.yau.doubao_community.model.dto.RegisterDTO;
import com.yau.doubao_community.model.entity.UmsUser;

public interface IUmsUserService extends IService<UmsUser> {

    // 用户注册
    UmsUser executeRegister(RegisterDTO dto);

    // 获取用户信息
    UmsUser getUserByUsername(String username);

    // 用户登录
    String executeLogin(LoginDTO dto);
}
