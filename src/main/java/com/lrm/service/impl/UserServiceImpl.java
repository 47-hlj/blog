package com.lrm.service.impl;

import com.lrm.NotFoundException;
import com.lrm.dao.UserRepository;
import com.lrm.po.User;
import com.lrm.service.UserService;
import com.lrm.util.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    @Override
    public User setUserAbout(Long id, User user){
        User u = userRepository.findById(id).get();
        if (u == null) {
            throw new NotFoundException("该用户不存在");
        }
        BeanUtils.copyProperties(user, u, MyBeanUtils.getNullPropertyNames(user));//替换相同属性。
        return userRepository.save(u);
    }
}
