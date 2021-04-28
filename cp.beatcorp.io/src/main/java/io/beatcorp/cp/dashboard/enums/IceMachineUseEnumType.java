package io.beatcorp.cp.dashboard.enums;


import io.beatcorp.cp.common.enums.CodeEnum;

public enum IceMachineUseEnumType implements CodeEnum {
    ERROR(-1, "미정의"),   // default 값으로 항상 셋팅
    NONE(0, "미사용"),
    ICE(1, "얼음"),
    WATER(2, "물"),
    ICE_WATER(2, "물과 얼음");

    final private int code;
    final private String desc;

    IceMachineUseEnumType(int code, String desc) {
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
