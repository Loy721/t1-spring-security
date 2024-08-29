package com.loy.t1springsecurity.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admins")
@PreAuthorize("hasRole('ADMIN')")
public class AdminControllerImpl implements AdminController {

    @GetMapping("/hi")
    public String sayHi() {
        return "User hi";
    }
}
