package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findById(Integer userId);
}
