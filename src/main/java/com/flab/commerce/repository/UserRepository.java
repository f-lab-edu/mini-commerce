package com.flab.commerce.repository;

import com.flab.commerce.domain.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
	Optional<Users> findById(Long id);
}
