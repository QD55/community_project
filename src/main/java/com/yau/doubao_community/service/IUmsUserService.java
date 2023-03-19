package com.yau.doubao_community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yau.doubao_community.model.dto.LoginDTO;
import com.yau.doubao_community.model.dto.RegisterDTO;
import com.yau.doubao_community.model.entity.UmsUser;
import com.yau.doubao_community.model.vo.ProfileVO;

public interface IUmsUserService extends IService<UmsUser> {

    /**
     * 用户注册
     * @param dto
     * @return
     */
    UmsUser executeRegister(RegisterDTO dto);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    UmsUser getUserByUsername(String username);

    /**
     * 用户登录
     * @param dto
     * @return
     */
    String executeLogin(LoginDTO dto);

    /**
     * 获取帖子
     * @param id
     * @return
     */
    ProfileVO getUserProfile(String id);

}
