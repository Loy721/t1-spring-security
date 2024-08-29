package com.loy.t1springsecurity.service.impl;

import com.loy.t1springsecurity.model.RefreshToken;
import com.loy.t1springsecurity.model.RoleType;
import com.loy.t1springsecurity.model.User;
import com.loy.t1springsecurity.model.UserRole;
import com.loy.t1springsecurity.model.dto.CreateUserRequest;
import com.loy.t1springsecurity.model.dto.RefreshTokenRequest;
import com.loy.t1springsecurity.model.dto.TokenResponse;
import com.loy.t1springsecurity.model.dto.UsernamePasswordRequest;
import com.loy.t1springsecurity.repository.UserRoleRepository;
import com.loy.t1springsecurity.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public TokenResponse sigIn(UsernamePasswordRequest usernamePasswordRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usernamePasswordRequest.getUsername(),
                usernamePasswordRequest.getPassword()));
        User user = userService.getUserByUsername(usernamePasswordRequest.getUsername());
        String accessToken = jwtService.generateToken(user);
        String refreshToken = refreshTokenService.create(user).getValue();
        return new TokenResponse(accessToken, refreshToken);
    }

    @Override
    public void signUp(CreateUserRequest request) {
        UserRole userRoleUer = userRoleService.getUserRoleByRoleType(RoleType.USER);
        User user = User.builder().username(request.getUsername()).email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())).roles(new HashSet<>(Set.of(userRoleUer))).build();
        userService.create(user);
    }

    @Override
    public TokenResponse refresh(RefreshTokenRequest refreshTokenRequest) {
        RefreshToken refreshToken = refreshTokenService.getByValue(refreshTokenRequest.getRefreshToken());
        if (refreshTokenService.isTokenExpired(refreshToken))
            throw new RuntimeException("ref tok exp");
        return new TokenResponse(jwtService.generateToken(refreshToken.getUser()), refreshTokenRequest.getRefreshToken());
    }
}
