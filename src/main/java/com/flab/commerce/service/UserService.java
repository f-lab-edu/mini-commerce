package com.flab.commerce.service;

import com.flab.commerce.domain.Users;
import com.flab.commerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long create(Users user) {
        return userRepository.save(user).getId();
    }
}
