package com.opendragonhuang.typehandler.mapper;

import com.opendragonhuang.typehandler.model.Human;

public interface HumanMapper {
    int insertHuman(Human human);
    Human findHuman(Long id);
}
