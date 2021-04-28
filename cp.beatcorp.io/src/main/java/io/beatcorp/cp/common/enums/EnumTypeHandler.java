package io.beatcorp.cp.common.enums;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumSet;


public class EnumTypeHandler<E extends Enum<E> & CodeEnum> extends BaseTypeHandler<E> {

    private Class<E> type;
    private static final int ERROR_CODE = -1;

    public EnumTypeHandler(Class<E> type) {
        if (type == null) throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            ps.setInt(i, parameter.getCode());
        } else {
            ps.setObject(i, parameter.getCode(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int s = rs.getInt(columnName);
        return getCodeEnum(type, s);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int s = rs.getInt(columnIndex);
        return getCodeEnum(type, s);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int s = cs.getInt(columnIndex);
        return getCodeEnum(type, s);
    }

    public static <T extends Enum<T> & CodeEnum> T getCodeEnum(Class<T> enumClass, int code) {
        return EnumSet.allOf(enumClass).stream()
                .filter(type -> type.getCode() == code)
                .findFirst()
                .orElse(getErrorEnum(enumClass));
    }

    public static <T extends Enum<T> & CodeEnum> T getErrorEnum(Class<T> enumClass) {
        return EnumSet.allOf(enumClass).stream()
                .filter(type -> type.getCode() == ERROR_CODE)
                .findFirst()
                .get();
    }
}
