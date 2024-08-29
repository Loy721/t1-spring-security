package com.loy.t1springsecurity.repository;

import com.loy.t1springsecurity.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    RefreshToken findByValue(String value);
}
