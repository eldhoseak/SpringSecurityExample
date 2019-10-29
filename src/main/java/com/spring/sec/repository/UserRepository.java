package com.spring.sec.repository;

import com.spring.sec.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository<P> extends CrudRepository<User, Long> {
User findByUserName(String userName);
}