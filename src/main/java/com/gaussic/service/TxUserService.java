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
