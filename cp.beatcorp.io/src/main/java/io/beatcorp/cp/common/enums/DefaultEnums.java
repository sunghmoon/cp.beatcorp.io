package io.beatcorp.cp.common.enums;

public enum DefaultEnums implements CodeEnum {
    ERROR(-1, "미정의");

    final private int code;
    final private String desc;

    DefaultEnums(int code, String desc) {
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
