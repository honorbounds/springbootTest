package com.honor.zhenghejpa.service;

import com.honor.zhenghejpa.dao.UserDAO;
import com.honor.zhenghejpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO dao;

    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public User saveUser(User user) {
        return dao.save(user);
    }

    public User findUserById(Long id){
        return dao.findById(id).get();
    }

    public User updateUser(User user){
        return dao.saveAndFlush(user);
    }

    public void deleteUser(Long id){
        dao.deleteById(id);
    }
}
