package com.yau.doubao_community.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@TableName("bms_tip")
public class BmsTip implements Serializable {

    private static final long serialVersionUID = 1L;

    // 主键
    @TableId(type = IdType.AUTO)
    private Integer id;

    // 内容
    @TableField("`content`")
    private String content;

    // 作者
    @TableField("author")
    private String author;

    // 展示状态 1: 未过期  0: 过期
    @TableField("`type`")
    private boolean type;
}
