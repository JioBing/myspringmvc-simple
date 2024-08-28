package com.gaussic.service;

import com.gaussic.model.UserEntity;
import com.gaussic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author huangpengbing
 * @Date 2024/8/28 0:31
 * @Version 1.0
 **/


@Service
public class UserService {

    private UserRepository userRepository;
    private final TxUserService txUserService;


    @Autowired
    public UserService(TxUserService txUserService) {
        this.txUserService = txUserService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = false)
    public void saveUser(UserEntity user) {
        userRepository.saveAndFlush(user);
        txUserService.updateNickName();
    }
}
