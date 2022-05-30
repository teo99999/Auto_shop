package com.informatics.cscb869f2020week7.data.repository;

import com.informatics.cscb869f2020week7.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
