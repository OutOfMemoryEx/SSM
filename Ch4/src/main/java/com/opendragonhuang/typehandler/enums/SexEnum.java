package com.opendragonhuang.typehandler.enums;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.TINYINT)
public enum SexEnum {
    FEMALE(0, "女"),
    MALE(1, "男");

    private int id;
    private String name;

    SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static SexEnum getSexById(int id){
        for (SexEnum value : SexEnum.values()) {
            if(value.getId() == id){
                return value;
            }
        }
        return null;
    }
}
