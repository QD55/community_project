package com.yau.doubao_community.common.exception;

import com.yau.doubao_community.common.api.IErrorCode;

public class ApiAsserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
