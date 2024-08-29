package com.loy.t1springsecurity.service;

import com.loy.t1springsecurity.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService  {

    User save(User user);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    User create(User user);

    User getUserByUsername(String username) throws UsernameNotFoundException;
}
