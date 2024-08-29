package com.loy.t1springsecurity.service.impl;

import com.loy.t1springsecurity.model.RoleType;
import com.loy.t1springsecurity.model.UserRole;
import com.loy.t1springsecurity.repository.UserRoleRepository;
import com.loy.t1springsecurity.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Override
    public UserRole getUserRoleByRoleType(RoleType roleType) {
        return userRoleRepository.findByRoleType(roleType);
    }
}
