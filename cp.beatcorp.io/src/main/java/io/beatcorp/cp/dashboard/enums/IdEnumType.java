package io.beatcorp.cp.dashboard.enums;

import io.beatcorp.cp.common.enums.CodeEnum;

public enum IdEnumType implements CodeEnum {
    ERROR(-1, "미정의"),   // default 값으로 항상 셋팅
    NONE(0, "미사용"),
    LEFT(1, "좌측"),
    RIGHT(2, "우측");

    final private int code;
    final private String desc;

    IdEnumType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
