package com.loy.t1springsecurity.service.impl;

import com.loy.t1springsecurity.model.RefreshToken;
import com.loy.t1springsecurity.model.User;
import com.loy.t1springsecurity.repository.RefreshTokenRepository;
import com.loy.t1springsecurity.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.refreshTokenExpiration}")
    private Duration refreshTokenExpiration;

    @Override
    public RefreshToken create(User user) {
        String refreshTokenValue = UUID.randomUUID().toString();
        RefreshToken refreshToken = new RefreshToken(null, refreshTokenValue, new Date(), user);

        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public RefreshToken getByValue(String value) {
        return refreshTokenRepository.findByValue(value);
    }


    @Override
    public boolean isTokenExpired(RefreshToken token) {
        Date expiratrionDate = new Date(token.getCreateDate().getTime() + refreshTokenExpiration.toMillis());
        return expiratrionDate.before(new Date());
    }
}
