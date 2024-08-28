package com.gaussic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @ClassName TxUserService
 * @Description TODO
 * @Author huangpengbing
 * @Date 2024/8/28 8:40
 * @Version 1.0
 **/

@Service
public class TxUserService {

    /**
     * @PersistenceContext是JPA专门用来注入entityManager对象的，使用@Autowired注入会有问题
     * 项目运行时，容器创建初始化了两个相同的实例，都指向了同一个代理对象，导致在@Service类中注入private  EntityManager entityManager报错
     * 对象类型EntityManager不唯一，因此改用@PersistenceContext注入，因为EntityManager是通过事务管理器工厂创建的，内部比较复杂。
     */
    private  EntityManager entityManager;
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    @Transactional
    public void updateNickName() {
        StringBuilder sqlBuild = new StringBuilder();
        sqlBuild.append("insert into user(nickname, password, first_name, last_name) values(:nickname, :password, :firstName, :lastName)");
        Query nativeQuery = entityManager.createNativeQuery(String.valueOf(sqlBuild));
        nativeQuery.setParameter("nickname", "wangwu");
        nativeQuery.setParameter("password", "999");
        nativeQuery.setParameter("firstName", "五");
        nativeQuery.setParameter("lastName", "王");
        nativeQuery.executeUpdate();
        int s = 10 / 0;
    }
}
