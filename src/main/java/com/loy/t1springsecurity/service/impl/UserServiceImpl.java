package com.loy.t1springsecurity.service.impl;

import com.loy.t1springsecurity.model.User;
import com.loy.t1springsecurity.model.UserDetailsImpl;
import com.loy.t1springsecurity.repository.UserRepository;
import com.loy.t1springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);//TODO excep
        return new UserDetailsImpl(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            throw new RuntimeException("Пользователь с никеймом существует");//TODO
        if (userRepository.existsByEmail(user.getEmail()))
            throw new RuntimeException("Пользователь с email существует");//TODO
        return save(user);
    }

    @Override
    public User getUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(RuntimeException::new);//TODO excep
    }
}
