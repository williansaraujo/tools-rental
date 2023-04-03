package com.willianaraujo.toolsrental.repository;

import com.willianaraujo.toolsrental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
