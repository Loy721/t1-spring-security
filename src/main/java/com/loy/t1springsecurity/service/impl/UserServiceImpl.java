package com.loy.t1springsecurity.service.impl;

import com.loy.t1springsecurity.model.User;
import com.loy.t1springsecurity.model.UserDetailsImpl;
import com.loy.t1springsecurity.model.exception.UserWithEmailAlreadyExistException;
import com.loy.t1springsecurity.model.exception.UserWithUsernameAlreadyExistException;
import com.loy.t1springsecurity.repository.UserRepository;
import com.loy.t1springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        Hibernate.initialize(user.getRoles());
        return new UserDetailsImpl(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            throw new UserWithUsernameAlreadyExistException("User with username: " + user.getUsername() + " exists");
        if (userRepository.existsByEmail(user.getEmail()))
            throw new UserWithEmailAlreadyExistException("User with email: " + user.getUsername() + " exists");
        return save(user);
    }

    @Override
    public User getUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));
    }
}
