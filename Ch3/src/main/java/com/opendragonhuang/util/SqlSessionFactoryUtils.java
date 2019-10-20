package com.opendragonhuang.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;

    private SqlSessionFactoryUtils(){}

    public static void sqlSessionFactoryInit(){
        synchronized(SqlSessionFactoryUtils.class){
            if(sqlSessionFactory == null){
                InputStream mybaitsConfig = SqlSessionFactoryUtils.class
                                                                  .getClassLoader()
                                                                  .getResourceAsStream("mybatis/mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybaitsConfig);

                try {
                    if(mybaitsConfig != null){
                        mybaitsConfig.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null){
            sqlSessionFactoryInit();
        }
        return sqlSessionFactory.openSession();
    }
}
