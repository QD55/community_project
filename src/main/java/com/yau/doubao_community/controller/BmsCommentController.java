package com.yau.doubao_community.controller;

import com.yau.doubao_community.common.api.ApiResult;
import com.yau.doubao_community.model.dto.CommentDTO;
import com.yau.doubao_community.model.entity.BmsComment;
import com.yau.doubao_community.model.entity.UmsUser;
import com.yau.doubao_community.model.vo.CommentVO;
import com.yau.doubao_community.service.IBmsCommentService;
import com.yau.doubao_community.service.IUmsUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.yau.doubao_community.jwt.JwtUtil.USER_NAME;

@RestController
@RequestMapping("/comment")
public class BmsCommentController extends BaseController {

    @Resource
    private IBmsCommentService bmsCommentService;

    @Resource
    private IUmsUserService umsUserService;

    @GetMapping("/get_comments")
    public ApiResult<List<CommentVO>> getCommentsByTopicID(@RequestParam(value = "topicid", defaultValue = "1") String topicid) {
        List<CommentVO> lstBmsComment = bmsCommentService.getCommentsByTopicID(topicid);
        return ApiResult.success(lstBmsComment);
    }

    @PostMapping("/add_comment")
    public ApiResult<BmsComment> addComments(@RequestHeader(value = USER_NAME) String userName,
                                              @RequestBody CommentDTO commentDTO) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        BmsComment comment = bmsCommentService.create(commentDTO, user);
        return ApiResult.success(comment);
    }


}