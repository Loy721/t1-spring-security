package com.loy.t1springsecurity.service;

import com.loy.t1springsecurity.model.User;
import com.loy.t1springsecurity.model.dto.TokenResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(User user);

    String extractUserName(String token);
     boolean isTokenValid(String token,  UserDetails userDetails);
}
