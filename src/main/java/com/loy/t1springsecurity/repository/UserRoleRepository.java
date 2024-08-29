package com.loy.t1springsecurity.repository;


import com.loy.t1springsecurity.model.RoleType;
import com.loy.t1springsecurity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRoleType(RoleType roleType);
}
