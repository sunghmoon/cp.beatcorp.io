package io.beatcorp.cp.common.enums;


import io.beatcorp.cp.dashboard.enums.IdEnumType;

import java.util.EnumSet;

public class EnumUtils {
    public static <T extends Enum<T> & CodeEnum> T getCodeEnum(Class<T> enumClass, int code) {
        return EnumSet.allOf(enumClass).stream()
                .filter(type -> type.getCode() == code)
                .findFirst()
                .orElse((T) IdEnumType.ERROR);
    }
}