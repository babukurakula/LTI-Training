package com.fullstack.UserRegistration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.UserRegistration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUserNameAndIsActiveAndIsDeleted(String userName,String isActive,String isDeleted);

}
