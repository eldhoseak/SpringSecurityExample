package com.spring.sec.repository;

import com.spring.sec.entity.AuthGroup;
import com.spring.sec.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthGroupRepository<P> extends CrudRepository<AuthGroup, Long> {
    List<AuthGroup> findByUserName(String userName);
}