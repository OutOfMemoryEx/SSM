package com.opendragonhuang.typehandler.model;

import com.opendragonhuang.typehandler.enums.SexEnum;
import lombok.Data;

@Data
public class Human {
    private Long id;
    private String name;
    private SexEnum sex;
}
