package edu.ynu.travel.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    private static SqlSessionFactory sessionFactory;
    private String resource;

    public MybatisUtil(String resource) {
        this.resource = resource;
    }

    public SqlSessionFactory getSessionFactory(){
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = new SqlSessionFactoryBuilder()
                .build(reader);
        return sessionFactory;
    }

    public static void closeSession(SqlSession session){
        if(null!=session){
            session.close();
        }
    }
}
