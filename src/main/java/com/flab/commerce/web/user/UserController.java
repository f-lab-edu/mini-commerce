package com.flab.commerce.web.user;

import com.flab.commerce.service.UserService;
import com.flab.commerce.web.dto.UserDto;
import com.flab.commerce.web.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @Operation(summary = "회원 가입", tags = {"User"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "OK")
    })
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Response create(@Valid @RequestBody UserDto user) {
        return Response.of(HttpStatus.CREATED)
                .addData(userService.create(user.toEntity()));
    }
}
