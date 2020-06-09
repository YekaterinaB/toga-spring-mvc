package com.springframework.togaspringmvc.repositories;

import com.springframework.togaspringmvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User repository, using JPA repository.
 */
public interface UserRepository extends JpaRepository<User,String> {
}
