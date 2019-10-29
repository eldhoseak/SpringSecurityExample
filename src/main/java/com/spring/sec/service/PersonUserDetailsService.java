package com.spring.sec.service;

import com.spring.sec.UserDetailsPrincipal;
import com.spring.sec.entity.AuthGroup;
import com.spring.sec.entity.User;
import com.spring.sec.repository.AuthGroupRepository;
import com.spring.sec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonUserDetailsService implements UserDetailsService {

    private UserRepository userRespository;

    @Autowired
    AuthGroupRepository authGroupRepository;


    public PersonUserDetailsService(UserRepository userRespository,  AuthGroupRepository authGroupRepository){
        super();
     this.userRespository = userRespository;
     this.authGroupRepository= authGroupRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user= this.userRespository.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User name not found");
        }

        List<AuthGroup> authGroups = this.authGroupRepository.findByUserName(userName);

        return new UserDetailsPrincipal(user, authGroups);
    }
}
