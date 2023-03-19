package com.yau.doubao_community.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yau.doubao_community.common.api.ApiResult;
import com.yau.doubao_community.model.dto.CreateTopicDTO;
import com.yau.doubao_community.model.entity.BmsPost;
import com.yau.doubao_community.model.entity.UmsUser;
import com.yau.doubao_community.model.vo.PostVO;
import com.yau.doubao_community.service.IBmsPostService;
import com.yau.doubao_community.service.IUmsUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.yau.doubao_community.jwt.JwtUtil.USER_NAME;

@RestController
@RequestMapping("/post")
public class BmsPostController extends BaseController {

    @Resource
    private IBmsPostService iBmsPostService;

    @Resource
    private IUmsUserService umsUserService;

    @GetMapping("/list")
    public ApiResult<Page<PostVO>> list(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<PostVO> list = iBmsPostService.getList(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }

    @PostMapping("/create")
    public ApiResult<BmsPost> create(@RequestHeader(value = USER_NAME) String userName,
                                     @RequestBody CreateTopicDTO dto) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        BmsPost topic = iBmsPostService.create(dto, user);
        return ApiResult.success(topic);

    }


}
