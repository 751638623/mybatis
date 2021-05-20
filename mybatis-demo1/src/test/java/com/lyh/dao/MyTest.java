package com.lyh.dao;

import com.lyh.mapper.UserMapper;
import com.lyh.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author 卢宇航
 * @Description
 * @create 2021-04-28 12:07
 */
public class MyTest {
    private SqlSessionFactory sqlSessionFactory = null;
    private User user;
    @Test
    public void selectUser() throws IOException {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 3. 创建SqlSessionFactory对象
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //方法二:
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();

        for (User user: users){
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void addUser() {
        SqlSession sqlSession =null;
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            // 2. 加载SqlMapConfig.xml配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 3. 创建SqlSessionFactory对象
            this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            // 4. 创建SqlSession对象
             sqlSession = sqlSessionFactory.openSession();
            //方法二:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(0,"赵六","123456");
            mapper.addUser(user);
            // 需要进行事务提交
            sqlSession.commit();
            System.out.println(" Insert Success！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }
    @Test
    public void delUserById(){
        SqlSession sqlSession =null;
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            // 2. 加载SqlMapConfig.xml配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 3. 创建SqlSessionFactory对象
            this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            // 4. 创建SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            //方法二:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.delUserById(0);
            // 需要进行事务提交
            sqlSession.commit();
            System.out.println(" del Success！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void updateUserById(){
        SqlSession sqlSession =null;
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            // 2. 加载SqlMapConfig.xml配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 3. 创建SqlSessionFactory对象
            this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            // 4. 创建SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            //方法二:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            user = new User(5,"武哥哥","55555");
            mapper.updateUserById(user);
            // 需要进行事务提交
            sqlSession.commit();
            System.out.println(" updata Success！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}

