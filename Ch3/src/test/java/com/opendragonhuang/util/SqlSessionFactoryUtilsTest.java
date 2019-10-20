package com.opendragonhuang.util;

import com.opendragonhuang.mapper.RoleMapper;
import com.opendragonhuang.model.Role;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SqlSessionFactoryUtilsTest {
    @Test
    public void mybatisTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = new Role();
        role.setRoleName("hkl");
        role.setNote("haha...");
        roleMapper.insertRole(role);
        sqlSession.commit();
    }

}