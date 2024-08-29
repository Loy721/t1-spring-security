package com.loy.t1springsecurity.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User controller")
public interface UserController {
    @Operation(
            summary = "Здоровается в ответ"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
    })
    String sayHi();
}
