package com.yau.doubao_community.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@TableName("bms_billboard")
public class BmsBillboard implements Serializable {

    private static final long serialVersionUID = 1L;

    // 主键
    @TableId(type = IdType.AUTO)
    private Integer id;

    // 公告牌
    @TableField("content")
    private String content;

    // 公告时间
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    // 公告牌状态  1:展示中  0:过期
    @Builder.Default
    @TableField("show")
    private boolean show = false;
}
