package com.farhaan.thefarhaanacademybank.repository;

import com.farhaan.thefarhaanacademybank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    // Add other custom query methods here as needed
}
