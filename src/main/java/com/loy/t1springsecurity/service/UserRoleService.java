package com.loy.t1springsecurity.service;

import com.loy.t1springsecurity.model.RoleType;
import com.loy.t1springsecurity.model.UserRole;

public interface UserRoleService {

    UserRole getUserRoleByRoleType(RoleType roleType);
}
