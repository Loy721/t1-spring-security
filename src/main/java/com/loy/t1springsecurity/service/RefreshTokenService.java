package com.loy.t1springsecurity.service;

import com.loy.t1springsecurity.model.RefreshToken;
import com.loy.t1springsecurity.model.User;

public interface RefreshTokenService {

    RefreshToken create(User user);

    RefreshToken getByValue(String value);

    boolean isTokenExpired(RefreshToken token);
}
