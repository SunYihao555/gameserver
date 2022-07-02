package com.mt.remoting.gameenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum CommonEnum {
    SUCCESS(200,"server call is success"),
    FAIL(400,"server call is fail");
    private final int code;
    private final String message;

}
