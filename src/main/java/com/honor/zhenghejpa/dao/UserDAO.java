package com.honor.zhenghejpa.dao;

import com.honor.zhenghejpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
