package com.spring.sec.service;

import com.spring.sec.UserDetailsPrincipal;
import com.spring.sec.model.User;
import com.spring.sec.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonUserDetailsService implements UserDetailsService {

    private UserRepository userRespository;

    public PersonUserDetailsService(UserRepository userRespository){
        super();
     this.userRespository = userRespository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user= this.userRespository.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User name not found");
        }

        return new UserDetailsPrincipal(user);
    }
}
