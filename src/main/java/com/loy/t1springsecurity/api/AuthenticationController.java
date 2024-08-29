package com.loy.t1springsecurity.api;

import com.loy.t1springsecurity.model.dto.CreateUserRequest;
import com.loy.t1springsecurity.model.dto.RefreshTokenRequest;
import com.loy.t1springsecurity.model.dto.TokenResponse;
import com.loy.t1springsecurity.model.dto.UsernamePasswordRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Auth controller")
public interface AuthenticationController {

    @Operation(
            summary = "Вход"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Возвращает access и refresh токены"),
            @ApiResponse(responseCode = "403", description = "Неправильный логин или пароль")
    })
    ResponseEntity<TokenResponse> signIn(UsernamePasswordRequest usernamePasswordRequest);


    @Operation(
            summary = "Регистрация"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Возвращает 'User created'"),
            @ApiResponse(responseCode = "403", description = "Такой пользователь уже существует")
    })
    ResponseEntity<String> signUp(CreateUserRequest createUserRequest);

    @Operation(
            summary = "Обновление access токена по refresh токену"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Возвращает обновленный access token и refresh"),
            @ApiResponse(responseCode = "403", description = "Невалидный токенё")
    })
    ResponseEntity<TokenResponse> refreshToken(RefreshTokenRequest refreshTokenRequest);


}
