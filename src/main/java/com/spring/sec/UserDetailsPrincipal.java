package com.spring.sec;

import com.spring.sec.entity.AuthGroup;
import com.spring.sec.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDetailsPrincipal implements UserDetails {

    private User user;
    private List<AuthGroup> authGroups;

    public UserDetailsPrincipal(User user, List<AuthGroup> authGroups){
        super();
this.user = user;
this.authGroups= authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

if(null == authGroups){
    return Collections.EMPTY_SET;
}
Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<SimpleGrantedAuthority>();

authGroups.forEach(group -> grantedAuthorities.add(new SimpleGrantedAuthority(group.getAuthGroup())));

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
