package com.flab.commerce.web.dto;

import com.flab.commerce.domain.Users;
import io.swagger.v3.oas.annotations.Parameter;
import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserDto {

    @Parameter(description = "로그인 ID", required = true)
    @NotBlank
    private String userId;

    @Parameter(description = "이름", required = true)
    @NotBlank
    private String name;

    @Parameter(description = "비밀번호", required = true)
    @NotBlank
    private String password;

    @Builder
    public UserDto(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public Users toEntity() {
        return Users.builder()
                .userId(this.userId)
                .name(this.name)
                .password(this.password)
                .build();
    }
}
