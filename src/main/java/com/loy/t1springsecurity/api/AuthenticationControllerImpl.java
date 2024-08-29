package com.loy.t1springsecurity.api;

import com.loy.t1springsecurity.model.dto.CreateUserRequest;
import com.loy.t1springsecurity.model.dto.RefreshTokenRequest;
import com.loy.t1springsecurity.model.dto.TokenResponse;
import com.loy.t1springsecurity.model.dto.UsernamePasswordRequest;
import com.loy.t1springsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> signIn(@RequestBody UsernamePasswordRequest usernamePasswordRequest) {
        return ResponseEntity.ok(authenticationService.sigIn(usernamePasswordRequest));
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody CreateUserRequest createUserRequest) {
        authenticationService.signUp(createUserRequest);
        return ResponseEntity.ok("User created");
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return   ResponseEntity.ok(authenticationService.refresh(refreshTokenRequest));
    }
}
