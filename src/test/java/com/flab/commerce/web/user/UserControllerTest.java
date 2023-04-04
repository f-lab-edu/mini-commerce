package com.flab.commerce.web.user;

import static org.assertj.core.api.Assertions.assertThat;

import com.flab.commerce.domain.Users;
import com.flab.commerce.repository.UserRepository;
import com.flab.commerce.web.dto.UserDto;
import com.flab.commerce.web.response.Response;
import java.util.Objects;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    private static final String LOCALHOST = "http://localhost:";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() throws Exception {
        String userId = "test_id";
        String name = "test_name";
        String password = "test_password";
        String url = LOCALHOST + port + "/rest/user";

        UserDto userDto = UserDto.builder()
                .userId(userId)
                .name(name)
                .password(password)
                .build();

        ResponseEntity<Response> responseEntity = testRestTemplate.postForEntity(url, userDto, Response.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(responseEntity.getBody()).isNotNull();

        Long id = Long.parseLong(String.valueOf(Objects.requireNonNull(responseEntity.getBody()).getData()));

        Optional<Users> optionalUser = userRepository.findById(id);

        assertThat(optionalUser.isPresent()).isTrue();

        Users user = optionalUser.get();

        assertThat(user.getUserId()).isEqualTo(userId);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPassword()).isEqualTo(password);
    }
}
