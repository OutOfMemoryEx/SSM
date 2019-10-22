package com.opendragonhuang.typehandler.util;

import com.opendragonhuang.typehandler.enums.SexEnum;
import com.opendragonhuang.typehandler.mapper.HumanMapper;
import com.opendragonhuang.typehandler.model.Human;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SqlSessionFactoryUtilsTest {
    @Test
    public void typeHandlerTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        HumanMapper humanMapper = sqlSession.getMapper(HumanMapper.class);
        Human human = new Human();
        human.setName("hkl");
        human.setSex(SexEnum.MALE);
        humanMapper.insertHuman(human);
        //Human human = humanMapper.findHuman(1L);
        System.out.println(human.getId());
        sqlSession.commit();
    }

}