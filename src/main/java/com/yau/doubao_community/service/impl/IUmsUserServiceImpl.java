package com.yau.doubao_community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yau.doubao_community.common.exception.ApiAsserts;
import com.yau.doubao_community.jwt.JwtUtil;
import com.yau.doubao_community.mapper.BmsTopicMapper;
import com.yau.doubao_community.mapper.UmsUserMapper;
import com.yau.doubao_community.model.dto.LoginDTO;
import com.yau.doubao_community.model.dto.RegisterDTO;
import com.yau.doubao_community.model.entity.UmsUser;
import com.yau.doubao_community.model.vo.ProfileVO;
import com.yau.doubao_community.service.IUmsUserService;
import com.yau.doubao_community.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class IUmsUserServiceImpl extends ServiceImpl<UmsUserMapper, UmsUser> implements IUmsUserService {

    @Autowired
    private BmsTopicMapper bmsTopicMapper;

    @Override
    public UmsUser executeRegister(RegisterDTO dto) {
        // 查询用户名是否重复
        LambdaQueryWrapper<UmsUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UmsUser::getUsername, dto.getName()).or().eq(UmsUser::getEmail, dto.getEmail());
        UmsUser umsUser = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(umsUser)) {
            ApiAsserts.fail("账号或邮箱已存在！");
        }
        UmsUser addUser = UmsUser.builder()
                .username(dto.getName())
                .alias(dto.getName())
                .password(MD5Utils.getPwd(dto.getPass()))
                .email(dto.getEmail())
                .createTime(new Date())
                .status(true)
                .build();
        baseMapper.insert(addUser);

        return addUser;
    }

    @Override
    public UmsUser getUserByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<UmsUser>().eq(UmsUser::getUsername, username));
    }

    @Override
    public String executeLogin(LoginDTO dto) {
        String token = null;

        try {
            UmsUser user = getUserByUsername(dto.getUsername());
            // 获取加密对象
            String encodePwd = MD5Utils.getPwd(dto.getPassword());
            if (!encodePwd.equals(user.getPassword())) {
                throw new Exception("密码错误");
            }
            token = JwtUtil.generateToken(String.valueOf(user.getUsername()));
        } catch (Exception e) {
            log.warn("用户不存在or密码验证失败=======>{}", dto.getUsername());
        }

        return token;
    }

    @Override
    public ProfileVO getUserProfile(String id) {
        ProfileVO profile = new ProfileVO();
        UmsUser user = baseMapper.selectById(id);
        BeanUtils.copyProperties(user, profile);
        return profile;
    }
}
