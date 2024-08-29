package com.loy.t1springsecurity.service;

import com.loy.t1springsecurity.model.dto.CreateUserRequest;
import com.loy.t1springsecurity.model.dto.RefreshTokenRequest;
import com.loy.t1springsecurity.model.dto.TokenResponse;
import com.loy.t1springsecurity.model.dto.UsernamePasswordRequest;

public interface AuthenticationService {

    TokenResponse sigIn(UsernamePasswordRequest usernamePasswordRequest);

    void signUp(CreateUserRequest createUserRequest);

    TokenResponse refresh(RefreshTokenRequest refreshTokenRequest);
}
