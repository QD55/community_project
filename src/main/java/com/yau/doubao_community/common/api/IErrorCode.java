package com.yau.doubao_community.common.api;

public interface IErrorCode {

    // 错误编码： -1失败  200成功
    Integer getCode();

    // 错误描述
    String getMessage();
}
